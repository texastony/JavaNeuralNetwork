package neural_network;


public class InputNeuron{
	/**
	 * The input value for the neuron.
	 */
	double inputValue;

	/**
	 * An input neuron only talks to the neural network.
	 * It does not learn, as it has no weights. It is simply how you 
	 * tell the network what your input is. Actually, it is entirely 
	 * optional. You could just set the hidden layer inputs direclty.
	 * I created them as most text books I have read draw them 
	 * and they are helpful as a concept to show the edge between
	 * the input neuron and the hidden layer neurons.
	 */
	public InputNeuron(){
		}
	
	/**
	 * Sets the input of the neuron.
	 * @param input
	 */
	public void setInput(double input){
		this.inputValue = input;
	}
	
	/**
	 * Returns the input.
	 * @return
	 */
	public double getOutput(){
		return inputValue;
	}
}
