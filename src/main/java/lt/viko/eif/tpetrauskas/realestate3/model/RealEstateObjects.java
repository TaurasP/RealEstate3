package lt.viko.eif.tpetrauskas.realestate3.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * RealEstateObjects entity is used to keep list of real estate objects.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "realEstateObjects")
@Getter
@Setter
public class RealEstateObjects {

    @XmlElement(name="realEstateObject")
    private ArrayList<RealEstateObject> realEstateObjects;
}
