
import java.util.Random;
import neural_network.*;

public class ThreeInput {

	public static void main(String[] args) {
		Random r = new Random(); //Create Random object for generating weights
		OutputNeuron output1 = new OutputNeuron(randomWeights(3, r), 2); //Create an Neurons, calling on randomWeights 
		HiddenNeuron hidden1 = new HiddenNeuron(randomWeights(4, r), 3); //to generate random weights for the neurons
		HiddenNeuron hidden2 = new HiddenNeuron(randomWeights(4, r), 3);
		InputNeuron x = new InputNeuron();//Input neurons have no wieghts...
		InputNeuron y = new InputNeuron();
		InputNeuron z = new InputNeuron();
		double error=2; //Initialize error (which is actually Root Mean-Square error) to something greater than the acceptable error
		double error0, error1, error2, error3, error4, error5, error6, error7;//Error values for each of the input subsets. In this case, since the inputs
		int counter =0; //are either 00, 01, 10, or 11, there are 4 error values.
		while(error > .01){ //Declare the acceptable error here
			error=0.0; //error must be declared before the for loop, or java will throw an error due to the if statements
			for(int count = 0;count < 8; count++){ //For the four input values
				if(count == 0){ //in the first case
					x.setInput(0.0);//the value of the first input is: 0
					y.setInput(0.0);//the value of the second input is: 0
					z.setInput(0.0);
				}
				else if(count == 1){//in the second case
					x.setInput(0.0);
					y.setInput(0.0);
					z.setInput(1.0);
				}
				else if(count == 2){//in the third case
					x.setInput(0.0);
					y.setInput(1.0);
					z.setInput(0.0);
				}
				else if(count == 3){//in the fourth case
					x.setInput(0.0);
					y.setInput(1.0);
					z.setInput(1.0);
				}
				else if(count == 4){//in the fourth case
					x.setInput(1.0);
					y.setInput(0.0);
					z.setInput(0.0);
				}
				else if(count == 5){//in the fourth case
					x.setInput(1.0);
					y.setInput(0.0);
					z.setInput(1.0);
				}
				else if(count == 6){//in the fourth case
					x.setInput(1.0);
					y.setInput(1.0);
					z.setInput(0.0);
				}
				else if(count == 7){//in the fourth case
					x.setInput(1.0);
					y.setInput(1.0);
					z.setInput(1.0);
				}
				double[] temp = {x.getOutput(), y.getOutput(), z.getOutput()};
				hidden1.setInput(temp);//Pass the hidden neurons the input values
				hidden2.setInput(temp);
//				hidden3.setInput(temp);
				double[] temp2 = {hidden1.getOutput(), hidden2.getOutput()};
				output1.setInput(temp2);//Pass the output neuron the hidden neuron's values
				if(count==0){//for the first case
					error0 = 0-output1.getOutput();//THIS IS WHAT YOU CHANGE TO SWITCH BETWEEN AND, NOR, XOR, etc.
					output1.updateWeight(error0); //you change the value that output1 is subtracted from 
					double[] htemp = {output1.getDelta()}; //This is all the code for the learning.
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					hidden3.updateWeight(htemp, h3temp);
					error=error0*error0;
				}
				else if(count==1){
					error1 = 0-output1.getOutput();
					output1.updateWeight(error1);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
					error+=error1*error1;
				}
				else if(count==2){
					error2 = 1-output1.getOutput();
					output1.updateWeight(error2);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
					error+=error2*error2;
				}
				else if (count == 3){
					error3 = 0-output1.getOutput();
					output1.updateWeight(error3);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					error+=error3*error3;
				}
				else if (count == 4){
					error4 = 0-output1.getOutput();
					output1.updateWeight(error4);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					error+=error4*error4;
				}
				else if (count == 5){
					error5 = 0-output1.getOutput();
					output1.updateWeight(error5);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					error+=error5*error5;
				}
				else if (count == 6){
					error6 = 1-output1.getOutput();
					output1.updateWeight(error6);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					error+=error6*error6;
				}
				else if (count == 7){
					error7 = 1-output1.getOutput();
					output1.updateWeight(error7);
					double[] htemp = {output1.getDelta()};
					double[] h1temp = {output1.getWeightValuePast()[0]};
					double[] h2temp = {output1.getWeightValuePast()[1]};
					hidden1.updateWeight(htemp, h1temp);
					hidden2.updateWeight(htemp, h2temp);
//					double[] h3temp = {output1.getWeightValuePast()[2]};
//					hidden3.updateWeight(htemp, h3temp);
					error+=error7*error7;
					error=error/8;
					error=java.lang.Math.sqrt(error);
					System.out.println("error =" + error);
				}
			}
		counter++;
		}//The following code outputs the trained networks results  for the inputs.
		System.out.println("0 0 0");
		x.setInput(0.0);
		y.setInput(0.0);
		z.setInput(0.0);
		double[] temp1 = {x.getOutput(), y.getOutput(), z.getOutput()};
		hidden1.setInput(temp1);
		hidden2.setInput(temp1);
		double [] temp2 = {hidden1.getOutput(), hidden2.getOutput()};
		output1.setInput(temp2);
		System.out.println(output1.getOutput());
		
		
		System.out.println("0 1 0");
		x.setInput(0.0);
		y.setInput(1.0);
		z.setInput(0.0);
		double[] temp3 = {x.getOutput(), y.getOutput(), z.getOutput()};
		hidden1.setInput(temp3);
		hidden2.setInput(temp3);
		double[] temp4 = {hidden1.getOutput(), hidden2.getOutput()};
		output1.setInput(temp4);
		System.out.println(output1.getOutput());
		
		
		System.out.println("1 1 0");
		x.setInput(1.0);
		y.setInput(1.0);
		z.setInput(0.0);
		double[] temp5 = {x.getOutput(), y.getOutput(), z.getOutput()};
		hidden1.setInput(temp5);
		hidden2.setInput(temp5);
		double[] temp6 = {hidden1.getOutput(), hidden2.getOutput()};
		output1.setInput(temp6);
		System.out.println(output1.getOutput());
		
		
		System.out.println("1 1 1");
		x.setInput(1.0);
		y.setInput(1.0);
		z.setInput(1.0);
		double[] temp7 = {x.getOutput(), y.getOutput(), z.getOutput()};
		hidden1.setInput(temp7);
		hidden2.setInput(temp7);
		double[] temp8 = {hidden1.getOutput(), hidden2.getOutput()};
		output1.setInput(temp8);
		System.out.println(output1.getOutput());
		
		System.out.println("1 0 1");
		x.setInput(1.0);
		y.setInput(0.0);
		z.setInput(1.0);
		double[] temp9 = {x.getOutput(), y.getOutput(), z.getOutput()};
		hidden1.setInput(temp9);
		hidden2.setInput(temp9);
		double[] temp10 = {hidden1.getOutput(), hidden2.getOutput()};
		output1.setInput(temp10);
		System.out.println(output1.getOutput());
		
		System.out.println(counter);
	}
	
	private static double[] randomWeights(int numInputs, Random r){
		double[] output = new double[numInputs];
		for(int i=0;i<numInputs;i++){
			output[i]=(r.nextDouble()-.5)*2*(2.4/numInputs);
		}
		return output;	
	}
}
