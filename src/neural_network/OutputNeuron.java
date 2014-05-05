package neural_network;

import java.lang.Math;

public class OutputNeuron{
	/**
	 * Array that holds the input values
	 */
	double[] inputValue;
	/**
	 * Holds the output Value
	 */
	double outputValue;
	/**
	 * Array that holds the weights
	 */
	double[] weightValue;
	/**
	 * Array that holds the weights of the previous iteration
	 */
	double[] weightValuePast;
	/**
	 * The Threshold of the nueron
	 */
	double threshold;
	/**
	 * The learning Factor (often represented by the greek alpha)
	 */
	double learningFactor;
	/**
	 * Delta is error gradient, often represented by the greek delta
	 */
	double delta;
	
	/**
	 * Creates an output Neuron. An output neuron can have any number of inputs,
	 * but only one output.
	 * 
	 * @param intialWeightValue; &nbsp;&nbsp;&nbsp;&nbsp;An array holding the initial weight values for the neuron. These should be random, 
	 * with a uniform distribution inside -(2.4)/numInputs, (2.4)/numInputs. There should be numInputs + 1 members in the array.
	 * The last element is the threshold weight, often represented by the greek theta. <p>
	 * 
	 * @param numInputs;  &nbsp;&nbsp;&nbsp;&nbsp;the number of nuerons feeding this into this neuron
	 */
	public OutputNeuron(double[] intialWeightValue, int numInputs){
		this.inputValue = new double[numInputs+1];
		this.threshold = -1;
		this.learningFactor = 01.0;
		this.weightValue = intialWeightValue;
		this.weightValuePast = new double[numInputs+1];
	}
	
	/** Sets the inputs of the nueron
	 * It should be passed an array of the same size
	 * as the number of inptus. 
	 * @param input
	 */
	public void setInput(double[] input){
		this.inputValue = input;
	}
	
	/**
	 * If you wanted to use something other than -1,
	 * this would change that. This Nueral network uses 
	 * the sigmoid function as the activation function, so -1
	 * is a very appropriate threshold
	 * @param threshold
	 */
	public void setThreshold(double threshold){
		this.threshold = threshold;
	}
	
	/**
	 * Essientally triggers the activation function with the current
	 * neuron attributes.
	 * <p>The activation function is the quotient of 1 divided by the sum of 1
	 * and e raised to the negative sum of the sum of the products of the weight values and
	 * the input values and the product of the threshold and its weight (theta).
	 * <p> Or 1/[1+e^(-1*[(inputs)*(weights)+(threshold)(theta)])]
	 *  
	 * @return a double;  &nbsp;&nbsp;&nbsp;&nbsp;The output of the neuron
	 */
	public double getOutput(){
		double tempValue=0;
		for (int i=0; i<inputValue.length; i++){
			tempValue = inputValue[i]*weightValue[i] + tempValue;
		}
		outputValue = tempValue + threshold*weightValue[inputValue.length];
		outputValue = 1/(1+Math.exp(-outputValue));
		return outputValue;
	}
	
	/**
	 * Triggers the weight correction procedure.
	 * As this an output neuron, there should be only one
	 * error passed to the function. This error should be 
	 * calculated by the desired output minus the actual output,
	 * or: <p>
	 * e_out = desired - actual
	 * <p> 
	 * The update function starts by calculating delta, the error gradient.
	 * The error gradient is the derivative of the activation function multiplied 
	 * by the error at the neuron output. This is why we use the Sigmoid function,
	 * its delta 
	 * <p>
	 * delta = output 
	 * 
	 * @param e_out 
	 */
	public void updateWeight(double e_out) {
//		System.out.print(outputValue+"  ");
		for(int i=0; i< weightValue.length; i++){
			weightValuePast[i] = weightValue[i];
		}
		delta=(outputValue-(outputValue*outputValue))*e_out;
		for (int i=0; i<inputValue.length; i++){
			weightValue[i]=weightValue[i]+learningFactor*inputValue[i]*delta;
		}
		weightValue[inputValue.length]=weightValue[inputValue.length]+learningFactor*threshold*delta;
//	System.out.println(e_out);
	}
	
	public double getDelta(){
		return delta;
	}
	public double[] getWeightValuePast(){
		return weightValuePast;
	}
}
