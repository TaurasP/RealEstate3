package lt.viko.eif.tpetrauskas.realestate3.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * RealEstateObject entity is used for realEstateObject's object creation.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "realEstateObject")
@Getter
@Setter
public class RealEstateObject implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name="uri")
    private String uri;
    @XmlAttribute(name="type")
    private String type;
    @XmlAttribute(name="price")
    private float price;
    @XmlAttribute(name="address")
    private String address;
    @XmlAttribute(name="squareMeters")
    private float squareMeters;
    @XmlAttribute(name="numberOfFloors")
    private int numberOfFloors;
    @XmlAttribute(name="isWater")
    private boolean isWater;
    @XmlAttribute(name="isGas")
    private boolean isGas;
    @XmlAttribute(name="isElectricity")
    private boolean isElectricity;
    @XmlAttribute(name="isSewerage")
    private boolean isSewerage;
}