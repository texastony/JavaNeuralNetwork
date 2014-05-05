
import java.util.Random;
import neural_network.*;

public class multiOut {

	public static void main(String[] args) {
		Random r = new Random(); //Create Random object for generating weights
		OutputNeuron no = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
		OutputNeuron eo = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
		OutputNeuron so = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
		OutputNeuron wo = new OutputNeuron(randomWeights(5, r), 4); //Create an Neurons, calling on randomWeights 
		HiddenNeuron hidden1 = new HiddenNeuron(randomWeights(5, r), 4); //to generate random weights for the neurons
		HiddenNeuron hidden2 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden3 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden4 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden21 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden22 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden23 = new HiddenNeuron(randomWeights(5, r), 4);
		HiddenNeuron hidden24 = new HiddenNeuron(randomWeights(5, r), 4);
		InputNeuron N = new InputNeuron();//Input neurons have no wieghts...
		InputNeuron E = new InputNeuron();
		InputNeuron S = new InputNeuron();
		InputNeuron W = new InputNeuron();
		double errorN, errorE, errorS, errorW, pastError = 2;
		double error=2; //Initialize error (which is actually Root Mean-Square error) to something greater than the acceptable error
		double error0, error1, error2, error3, error4, error5, error6, error7, error8, error9, error10, error11, error12, error13, error14, error15;//Error values for each of the input subsets. In this case, since the inputs
		int counter =0; //are either 00, 01, 10, or 11, there are 4 error values.
		while(error > 0.01){ //Declare the acceptable error here
			for(int count = 0;count < 16; count++){ //For the four input values
				if(count == 0){ //in the first case
					N.setInput(0.0);//the value of the first input is: 0
					E.setInput(0.0);//the value of the second input is: 0
					S.setInput(0.0);
					W.setInput(0.0);
				}
				else if(count == 1){//in the second case
					N.setInput(0.0);
					E.setInput(0.0);
					S.setInput(0.0);
					W.setInput(1.0);
				}
				else if(count == 2){//in the third case
					N.setInput(0.0);
					E.setInput(0.0);
					S.setInput(1.0);
					W.setInput(0.0);
				}
				else if(count == 3){//in the fourth case
					N.setInput(0.0);
					E.setInput(0.0);
					S.setInput(1.0);
					W.setInput(1.0);
				}
				else if(count == 4){//in the fourth case
					N.setInput(0.0);
					E.setInput(1.0);
					S.setInput(0.0);
					W.setInput(0.0);
				}
				else if(count == 5){//in the fourth case
					N.setInput(0.0);
					E.setInput(1.0);
					S.setInput(0.0);
					W.setInput(1.0);
				}
				else if(count == 6){//in the fourth case
					N.setInput(0.0);
					E.setInput(1.0);
					S.setInput(1.0);
					W.setInput(0.0);
				}
				else if(count == 7){//in the fourth case
					N.setInput(0.0);
					E.setInput(1.0);
					S.setInput(1.0);
					W.setInput(1.0);
				}
				else if(count == 8){//in the fourth case
					N.setInput(1.0);
					E.setInput(0.0);
					S.setInput(0.0);
					W.setInput(0.0);
				}
				else if(count == 9){//in the fourth case
					N.setInput(1.0);
					E.setInput(0.0);
					S.setInput(0.0);
					W.setInput(1.0);
				}
				else if(count == 10){//in the fourth case
					N.setInput(1.0);
					E.setInput(0.0);
					S.setInput(1.0);
					W.setInput(0.0);
				}
				else if(count == 11){//in the fourth case
					N.setInput(1.0);
					E.setInput(0.0);
					S.setInput(1.0);
					W.setInput(1.0);
				}
				else if(count == 12){//in the fourth case
					N.setInput(1.0);
					E.setInput(1.0);
					S.setInput(0.0);
					W.setInput(0.0);
				}
				else if(count == 13){//in the fourth case
					N.setInput(1.0);
					E.setInput(1.0);
					S.setInput(0.0);
					W.setInput(1.0);
				}
				else if(count == 14){//in the fourth case
					N.setInput(1.0);
					E.setInput(1.0);
					S.setInput(1.0);
					W.setInput(0.0);
				}
				else if(count == 15){//in the fourth case
					N.setInput(1.0);
					E.setInput(1.0);
					S.setInput(1.0);
					W.setInput(1.0);
				}
				double[] temp = {N.getOutput(), E.getOutput(), S.getOutput(),  W.getOutput()};
				hidden1.setInput(temp);//Pass the hidden neurons the input values
				hidden2.setInput(temp);
				hidden3.setInput(temp);
				hidden4.setInput(temp);
				double[] temp22 = {hidden1.getOutput(), hidden2.getOutput(), hidden3.getOutput(), hidden4.getOutput()};
				hidden21.setInput(temp22);//Pass the hidden neurons the input values
				hidden22.setInput(temp22);
				hidden23.setInput(temp22);
				hidden24.setInput(temp22);
//				hidden3.setInput(temp);
				double[] temp2 = {hidden21.getOutput(), hidden22.getOutput(), hidden23.getOutput(), hidden24.getOutput()};
				no.setInput(temp2);//Pass the output neuron the hidden neuron's values
				eo.setInput(temp2);
				so.setInput(temp2);
				wo.setInput(temp2);
				if(count==0){//for the first case
					//THIS IS WHAT YOU CHANGE TO SWITCH BETWEEN AND, NOR, XOR, etc.
					errorN = 0-no.getOutput();
					errorE = 0-eo.getOutput();
					errorS = 0-so.getOutput();
					errorW = 0-wo.getOutput();	
					error0 = (errorN + errorE + errorS + errorW)/4;
					error=error0*error0;
				}
				else if(count==1){
					errorN = 0-no.getOutput();
					errorE = 0-eo.getOutput();
					errorS = 0-so.getOutput();
					errorW = 1-wo.getOutput();	
					error1 = (errorN + errorE + errorS + errorW)/4;
					error+=error1*error1;
				}
				else if(count==2 || count==3){
					errorN = 0-no.getOutput();
					errorE = 0-eo.getOutput();
					errorS = 1-so.getOutput();
					errorW = 0-wo.getOutput();
					if (count == 2){
						error2 = (errorN + errorE + errorS + errorW)/4;
						error+=error2*error2;
					}
					else {
						error3 = (errorN + errorE + errorS + errorW)/4;
						error+=error3*error3;
					}					
				}
				else if (count > 3 && count < 8){
					errorN = 0-no.getOutput();
					errorE = 1-eo.getOutput();
					errorS = 0-so.getOutput();
					errorW = 0-wo.getOutput();
					if (count == 4){
						error4 = (errorN + errorE + errorS + errorW)/4;
						error+=error4*error4;
					}
					else if (count == 5){
						error5 = (errorN + errorE + errorS + errorW)/4;
						error+=error5*error5;
					}
					else if (count == 6){
						error6 = (errorN + errorE + errorS + errorW)/4;
						error+=error6*error6;
					}
					else {
						error7 = (errorN + errorE + errorS + errorW)/4;
						error+=error7*error7;
					}					
				}
				else {
					errorN = 1-no.getOutput();
					errorE = 0-eo.getOutput();
					errorS = 0-so.getOutput();
					errorW = 0-wo.getOutput();
					if (count == 8){
						error8 = (errorN + errorE + errorS + errorW)/4;
						error+=error8*error8;
					}
					else if (count == 9){
						error9 = (errorN + errorE + errorS + errorW)/4;
						error+=error9*error9;
					}
					else if (count == 10){
						error10 = (errorN + errorE + errorS + errorW)/4;
						error+=error10*error10;
					}
					else if (count == 11){
						error11 = (errorN + errorE + errorS + errorW)/4;
						error+=error11*error11;
					}
					else if (count == 12){
						error12 = (errorN + errorE + errorS + errorW)/4;
						error+=error12*error12;
					}
					else if (count == 13){
						error13 = (errorN + errorE + errorS + errorW)/4;
						error+=error13*error13;
					}
					else if (count == 14){
						error14 = (errorN + errorE + errorS + errorW)/4;
						error+=error14*error14;
					}
					else {
						error15 = (errorN + errorE + errorS + errorW)/4;
						error+=error15*error15;
						error=error/16;
						error=java.lang.Math.sqrt(error);
						
						if (error < pastError) {
							pastError = error;
							System.out.println("error =" + error);
						}
					}
				}
				no.updateWeight(errorN); //you change the value that output1 is subtracted from 
				eo.updateWeight(errorE);
				wo.updateWeight(errorS);
				so.updateWeight(errorW);
				double[] htemp = {no.getDelta(), eo.getDelta(), so.getDelta(), wo.getDelta()}; //This is all the code for the learning.
				double[] h1temp = {no.getWeightValuePast()[0], eo.getWeightValuePast()[0], so.getWeightValuePast()[0], wo.getWeightValuePast()[0]};
				double[] h2temp = {no.getWeightValuePast()[1], eo.getWeightValuePast()[1], so.getWeightValuePast()[1], wo.getWeightValuePast()[1]};
				hidden21.updateWeight(htemp, h1temp);
				hidden22.updateWeight(htemp, h2temp);
				hidden23.updateWeight(htemp, h1temp);
				hidden24.updateWeight(htemp, h2temp);
			}
		counter++;
		}//The following code outputs the trained networks results  for the inputs.
		System.out.println("0 0 0 0");
		N.setInput(0.0);
		E.setInput(0.0);
		S.setInput(0.0);
		W.setInput(0.0);
		double[] temp1 = {N.getOutput(), E.getOutput(), S.getOutput(), W.getOutput()};
		hidden1.setInput(temp1);
		hidden2.setInput(temp1);
		double [] temp2 = {hidden1.getOutput(), hidden2.getOutput()};
		no.setInput(temp2);
		eo.setInput(temp2);
		so.setInput(temp2);
		wo.setInput(temp2);
		System.out.println(no.getOutput() + " " + eo.getOutput() + " " + so.getOutput() + " " + wo.getOutput());
		
		
		System.out.println("0 0 0 1");
		N.setInput(0.0);
		E.setInput(0.0);
		S.setInput(0.0);
		W.setInput(1.0);
		double[] temp3 = {N.getOutput(), E.getOutput(), S.getOutput(), W.getOutput()};
		hidden1.setInput(temp3);
		hidden2.setInput(temp3);
		double [] temp4 = {hidden1.getOutput(), hidden2.getOutput()};
		no.setInput(temp4);
		eo.setInput(temp4);
		so.setInput(temp4);
		wo.setInput(temp4);
		System.out.println(no.getOutput() + " " + eo.getOutput() + " " + so.getOutput() + " " + wo.getOutput());
		
		
		System.out.println("0 0 1 0");
		N.setInput(0.0);
		E.setInput(0.0);
		S.setInput(1.0);
		W.setInput(0.0);
		double[] temp5 = {N.getOutput(), E.getOutput(), S.getOutput(), W.getOutput()};
		hidden1.setInput(temp5);
		hidden2.setInput(temp5);
		double [] temp6 = {hidden1.getOutput(), hidden2.getOutput()};
		no.setInput(temp6);
		eo.setInput(temp6);
		so.setInput(temp6);
		wo.setInput(temp6);
		System.out.println(no.getOutput() + " " + eo.getOutput() + " " + so.getOutput() + " " + wo.getOutput());
		
		
		
		System.out.println("0 1 0 0");
		N.setInput(0.0);
		E.setInput(1.0);
		S.setInput(0.0);
		W.setInput(0.0);
		double[] temp7 = {N.getOutput(), E.getOutput(), S.getOutput(), W.getOutput()};
		hidden1.setInput(temp7);
		hidden2.setInput(temp7);
		double [] temp8 = {hidden1.getOutput(), hidden2.getOutput()};
		no.setInput(temp8);
		eo.setInput(temp8);
		so.setInput(temp8);
		wo.setInput(temp8);
		System.out.println(no.getOutput() + " " + eo.getOutput() + " " + so.getOutput() + " " + wo.getOutput());
		
		System.out.println("1 0 0 0");
		N.setInput(1.0);
		E.setInput(0.0);
		S.setInput(0.0);
		W.setInput(0.0);
		double[] temp9 = {N.getOutput(), E.getOutput(), S.getOutput(), W.getOutput()};
		hidden1.setInput(temp9);
		hidden2.setInput(temp9);
		double [] temp10 = {hidden1.getOutput(), hidden2.getOutput()};
		no.setInput(temp10);
		eo.setInput(temp10);
		so.setInput(temp10);
		wo.setInput(temp10);
		System.out.println(no.getOutput() + " " + eo.getOutput() + " " + so.getOutput() + " " + wo.getOutput());
		
		
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
