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
		this.weightValuePast = new double[numInputs];
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
	 * &nbsp;&nbsp;As this an output neuron, there should be only one
	 * error passed to the function. This error should be 
	 * calculated by the desired output minus the actual output,
	 * or: <br>
	 * e_out = desired - actual
	 * <p>
	 * &nbsp;&nbsp;The update function starts by calculating delta, the error gradient.
	 * The error gradient is the derivative of the activation function multiplied 
	 * by the error at the neuron output. This is why we use the Sigmoid function,
	 * as the derivative of the sigmoid function is: 
	 * <br> Sigmoid_prime = Sigmoid * (1 - Sigmoid) <p>
	 * &nbsp;&nbsp;Applied to our case:<br>
	 * delta = output * (1 - output) * e_out
	 * <p>
	 * &nbsp;&nbsp;Then, every weight (including the threshold weight, theta) is updated to be
	 * the sum of the weight and the product of the learning factor, the input value, 
	 * and delta.<p>
	 * &nbsp;&nbsp;In terms of operations, this function copies the current weights to previous weight
	 * array, does the above the arithmetic, and stores these values as the weights.
	 * 
	 * @param e_out &nbsp;&nbsp;e_out = desired - actual
	 */
	public void updateWeight(double e_out) {
		delta=(outputValue-(outputValue*outputValue))*e_out;
		for (int i=0; i<inputValue.length; i++){
			weightValuePast[i] = weightValue[i];
			weightValue[i]=weightValue[i]+learningFactor*inputValue[i]*delta;
		}
		weightValue[inputValue.length]=weightValue[inputValue.length]+learningFactor*threshold*delta;
	}
	
	/**
	 * When calculating the error gradients for the hidden layer neurons outputing
	 * to this neuron, you will need this neuron's delta. That is what
	 * this function is for. It does not modify anything.
	 * @return double delta &nbsp;&nbsp;This neuron's error gradient (or delta) from the most recent update.
	 */
	public double getDelta(){
		return delta;
	}
	
	/**
	 * When calculating the error gradeint for the hidden layer neurons outputing
	 * to this neuron, you will need the original weights. The weights that have not
	 * been corrected by calling <code> updateWight() </code>. This function returns all
	 * of the weights.
	 * @return double[numInputs+1] weightValuePast; &nbsp;&nbsp;The weights before the most recent update.
	 */
	public double[] getWeightValuePast(){
		return weightValuePast;
	}
	
	/**
	 * If you wanted to use something other than 1,
	 * this would change that. 
	 * @param Learning
	 */
	public void setLearning(double Learning){
		this.learningFactor = Learning;
	}
}
