package texastony.neural_network;

import java.lang.Math;

public class HiddenNeuron{
	double[] inputValue;
	double outputValue;
	double[] weightValue;
	double threshold;
	double learningFactor;
	double delta;
	public HiddenNeuron(double[] intialWeightValue, int numInputs){
		this.inputValue = new double[numInputs+1];
		this.threshold = -1.0;
		this.learningFactor = 10;
		this.weightValue = new double[numInputs+1];
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
		tempValue=+ threshold*weightValue[inputValue.length+1];
		outputValue = 1/(1+Math.exp(-outputValue));
		return outputValue;
	}
	public void updateWeight(double[] deltaOut, double[] pastWeights) {
		double sumDeltaWeight=0.0;
		for (int i=0;i<deltaOut.length;i++){
			sumDeltaWeight=deltaOut[i]*pastWeights[i]+sumDeltaWeight;
		}
		delta = outputValue*(1-outputValue)*sumDeltaWeight;
		for (int i=0; i<inputValue.length; i++){
			weightValue[i]=weightValue[i]+learningFactor*inputValue[i]*delta;
		}
	}
}
