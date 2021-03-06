package org.jclouds.azure.servicemanagement.domain.virtualmachine;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Protocol")
@XmlEnum
public enum Protocol {
	@XmlEnumValue("tcp")
	TCP,
	@XmlEnumValue("http")
	HTTP,
	@XmlEnumValue("udp")
	UDP;
	
}
