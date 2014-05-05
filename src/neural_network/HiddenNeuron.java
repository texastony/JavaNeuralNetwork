package neural_network;

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
		this.learningFactor = 01.0;
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
			tempValue+= inputValue[i]*weightValue[i];
		}
		tempValue+= threshold*weightValue[inputValue.length];
		outputValue = 1/(1+Math.exp(-tempValue));
		return outputValue;
	}
	
	public void changeDelta(double[] deltaOut, double[] pastWeights){
		double sumDeltaWeight=0.0;
//		for (int i=0;i<deltaOut.length;i++){
//			sumDeltaWeight+=deltaOut[i]*pastWeights[i];
//		}
		sumDeltaWeight=deltaOut[0]*pastWeights[0];
		delta = outputValue*(1-outputValue)*sumDeltaWeight;
	}
	
	public void updateWeight(double[] deltaOut, double[] pastWeights) {
		changeDelta(deltaOut, pastWeights);
		for (int i=0; i<inputValue.length; i++){
			weightValue[i]+=learningFactor*inputValue[i]*delta;
		}
		weightValue[inputValue.length]+=learningFactor*threshold*delta;
	}
}
