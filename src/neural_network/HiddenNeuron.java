package neural_network;

import java.lang.Math;

public class HiddenNeuron{
	/**
	 * Array that holds the input values
	 */
	double[] inputValue;
	/**
	 * Holds the output Value, which is calculated by the activation function.
	 */
	double outputValue;
	/**
	 * Array that holds the weights. Initialized by the caller at creation. Adjusted by 
	 * the class at <code>updateWeights()</code>.
	 */
	double[] weightValue;
	/**
	 * The Threshold of the nueron, default is -1, but can be changed by <code>setThreshold()</code>.
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
	 * Array that holds the last iterations weights.
	 */
	double[] weightValuePast;
	

	/**
	 * Creates a Hidden Neuron. A hidden neuron can take multiple inputs,
	 * and can output to several output neurons. It is distinct from an output neuron 
	 * in that it takes the error gradients and the weights of all the neurons above it
	 * to calculate its error gradient.
	 * 
	 * @param intialWeightValue; &nbsp;&nbsp;&nbsp;&nbsp;An array holding the initial weight values for the neuron. These should be random, 
	 * with a uniform distribution inside -(2.4)/numInputs, (2.4)/numInputs. There should be numInputs + 1 members in the array.
	 * The last element is the threshold weight, often represented by the greek theta. <p>
	 * 
	 * @param numInputs;  &nbsp;&nbsp;&nbsp;&nbsp;the number of nuerons feeding this into this neuron
	 */
	public HiddenNeuron(double[] intialWeightValue, int numInputs){
		this.inputValue = new double[numInputs+1];
		this.threshold = -1.0;
		this.learningFactor = 01.0;
		this.weightValue = new double[numInputs+1];
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
	 * If you wanted to use something other than 1,
	 * this would change that. 
	 * @param Learning
	 */
	public void setLearning(double Learning){
		this.learningFactor = Learning;
	}
	
	/**
	 * Essientally triggers the activation function with the current
	 * neuron attributes.
	 * <p>&nbsp;&nbsp;The activation function is the quotient of 1 divided by the sum of 1
	 * and e raised to the negative sum of the sum of the products of the weight values and
	 * the input values and the product of the threshold and its weight (theta).
	 * <p> or: 1/[1+e^(-1*[(inputs)*(weights)+(threshold)(theta)])]
	 *  
	 * @return a double;  &nbsp;&nbsp;The output of the neuron
	 */
	public double getOutput(){
		double tempValue=0;
		for (int i=0; i<inputValue.length; i++){
			tempValue+= inputValue[i]*weightValue[i];
		}
		tempValue+= threshold*weightValue[inputValue.length];
		outputValue = 1/(1+Math.exp(-tempValue));
		return outputValue;
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
	 * Updating the weights in the hidden layer is a trikey process;
	 * creating this process is what allowed back propagaion to work.
	 * <p> &nbsp;&nbsp;
	 * In order to determine how to correct the weights, the neuron needs
	 * to know how much the neuron's output affected the output of the neural network,
	 * and in which direction it should correct its output. The first is represented 
	 * by the weight the recieving neuron placed on this neuron's input. The second is
	 * represented by the error gradient calculated by the recieving neuron.
	 * <p> &nbsp;&nbsp;
	 * Therefore, this neuron will need the past Weight of every neuron that it
	 * outputs to, as well as their current delta. The caller passes these to 
	 * this neuron as the parameters for this function. Each array must be in the same
	 * order. That is to say, if this neuron is outputing to Output Neurons A and B,
	 * the parameters must be: {A's delta, B's Delta}, {A's pastWeight, B's pastWeight}.
	 * <p> &nbsp;&nbsp;
	 * The deltaOuts are then multiplied by the pastWieghts, these are summed, and the
	 * error gradient (delta) for this neuron is calculated by the this sum multiplied by 
	 * the derivative of the activation function.
	 * @param deltaOut &nbsp;&nbsp;Must be in the same order as the pastWeights
	 * @param pastWeights &nbsp;&nbsp;Must be in the same order as the deltaOut
	 */
	public void changeDelta(double[] deltaOut, double[] pastWeights){
		double sumDeltaWeight=0.0;
		for (int i=0;i<deltaOut.length;i++){
			sumDeltaWeight+=deltaOut[i]*pastWeights[i];
		}
		delta = outputValue*(1-outputValue)*sumDeltaWeight;
	}
	
	/**
	 * Updating the weights in the hidden layer is a trikey process;
	 * creating this process is what allowed back propagaion to work.
	 * <p> &nbsp;&nbsp;
	 * In order to determine how to correct the weights, the neuron needs
	 * to know how much the neuron's output affected the output of the neural network,
	 * and in which direction it should correct its output. The first is represented 
	 * by the weight the recieving neuron placed on this neuron's input. The second is
	 * represented by the error gradient calculated by the recieving neuron.
	 * <p> &nbsp;&nbsp;
	 * Therefore, this neuron will need the past Weight of every neuron that it
	 * outputs to, as well as their current delta. The caller passes these to 
	 * this neuron as the parameters for this function. Each array must be in the same
	 * order. That is to say, if this neuron is outputing to Output Neurons A and B,
	 * the parameters must be: {A's delta, B's Delta}, {A's pastWeight, B's pastWeight}.
	 * <p> &nbsp;&nbsp;
	 * The deltaOuts are then multiplied by the pastWieghts, these are summed, and the
	 * error gradient (delta) for this neuron is calculated by this sum multiplied by 
	 * the derivative of the activation function.
	 * <p> &nbsp;&nbsp;
	 * The new weights are then calculated by this error gradient, multiplied by the
	 * input value and the learning factor.
	 * @param deltaOut &nbsp;&nbsp;Must be in the same order as the pastWeights
	 * @param pastWeights &nbsp;&nbsp;Must be in the same order as the deltaOut
	 */
	public void updateWeight(double[] deltaOut, double[] pastWeights) {
		changeDelta(deltaOut, pastWeights);
		for (int i=0; i<inputValue.length; i++){
			weightValuePast[i] = weightValue[i];
			weightValue[i]+=learningFactor*inputValue[i]*delta;
		}
		weightValue[inputValue.length]+=learningFactor*threshold*delta;
	}
}
