package texastony.neural_network;

import java.util.Arrays;
import java.util.Random;
import texastony.neural_network.OutputNeuron;
import java.lang.Math;

public class TestUpdate {
	public static void main(String[] args) {
		double outputValue=5;
//		double tempValue=0;
//		tempValue = inputValue[i]*weightValue[i] + tempValue;
//		outputValue = tempValue - threshold;
		outputValue = 1/(1+Math.exp(-outputValue));
		System.out.println(outputValue);
	}
}
