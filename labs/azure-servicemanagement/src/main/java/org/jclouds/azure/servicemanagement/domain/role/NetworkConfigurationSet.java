package org.jclouds.azure.servicemanagement.domain.role;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConfigurationSet")
public class NetworkConfigurationSet extends ConfigurationSet{
	
	public final static String ID = "NetworkConfiguration";

	/**
	 * Contains a collection of external endpoints for the virtual machine.
	 */
	@XmlElementWrapper(name = "InputEndpoints")
	@XmlElement(name = "InputEndpoint")
	private List<InputEndpoint> inputEndpoints = new ArrayList<InputEndpoint>(0);
	
	/**
	 * Specifies the name of a subnet to which the virtual machine belongs.
	 */
	@XmlElementWrapper(name = "SubnetNames")
	@XmlElement(name = "SubnetName")
 	private List<String> subnetNames = new ArrayList<String>(0);

	public NetworkConfigurationSet(){
		setConfigurationSetType(ID);
	}
	
	public List<InputEndpoint> getInputEndpoints() {
		return inputEndpoints;
	}

	public void setInputEndpoints(List<InputEndpoint> inputEndpoints) {
		this.inputEndpoints = inputEndpoints;
	}

	public List<String> getSubnetNames() {
		return subnetNames;
	}

	public void setSubnetNames(List<String> subnetNames) {
		this.subnetNames = subnetNames;
	}

	@Override
	public String toString() {
		return "NetworkConfigurationSet [configurationSetType=" + configurationSetType
				+ ", InputEndpoints=" + inputEndpoints + ", SubnetNames="
				+ subnetNames + "]";
	}
	
	
}
