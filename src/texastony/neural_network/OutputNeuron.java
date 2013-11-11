package texastony.neural_network;

import java.lang.Math;

public class OutputNeuron{
	double[] inputValue;
	double outputValue;
	double[] weightValue;
	double[] weightValuePast;
	double threshold;
	double learningFactor;
	double delta;
	public OutputNeuron(double[] intialWeightValue, int numInputs){
		this.inputValue = new double[numInputs];
		this.threshold = 1.0;
		this.learningFactor = 1.0;
		this.weightValue = intialWeightValue;
	}
	public void setInput(double[] input){
		this.inputValue = input;
	}
	public void setThreshold(double threshold){
		this.threshold = threshold;
	}
	public double getOutput(){
		double tempValue=0;
		for (int i=0; i<inputValue.length; i++){
			tempValue = inputValue[i]*weightValue[i] + tempValue;
		}
		outputValue = tempValue - threshold;
		outputValue = 1/(1+Math.exp(-outputValue));
		return outputValue;
	}
	public void updateWeight(double e_out) {
		weightValuePast = weightValue;
		delta=outputValue*(1-outputValue)*e_out;
		for (int i=0; i<inputValue.length; i++){
			weightValue[i]=weightValue[i]+learningFactor*inputValue[i]*delta;
		}
	}
	public double getDelta(){
		return delta;
	}
	public double[] getWeightValuePast(){
		return weightValuePast;
	}
}
