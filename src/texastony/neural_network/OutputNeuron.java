package texastony.neural_network;

import java.lang.Math;
import java.util.Arrays;

public class OutputNeuron{
	double[] inputValue;
	double outputValue;
	double[] weightValue;
	double[] weightValuePast;
	double threshold;
	double learningFactor;
	double delta;
	public OutputNeuron(double[] intialWeightValue, int numInputs){
		this.inputValue = new double[numInputs+1];
		this.threshold = -1;
		this.learningFactor = 10;
		this.weightValue = intialWeightValue;
		this.weightValuePast = new double[numInputs+1];
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
		outputValue = tempValue + threshold*weightValue[inputValue.length];
		outputValue = 1/(1+Math.exp(-outputValue));
		return outputValue;
	}
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
