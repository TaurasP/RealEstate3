package lt.viko.eif.tpetrauskas.realestate3.controller;

import lt.viko.eif.tpetrauskas.realestate3.model.RealEstateObject;
import lt.viko.eif.tpetrauskas.realestate3.model.RealEstateObjects;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * RealEstateResource entity is used for REST CRUD methods implementation.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "realEstateObjects")
@Path("/realEstateObjects")
public class RealEstateObjectResource {
    private static Map<Integer, RealEstateObject> DB = new HashMap<>();


    /**
     * Gets all real estate objects.
     *
     * @return list of real estate objects
     */
    @GET
    @Produces("application/json")
    public RealEstateObjects getAllRealEstateObjects() {
        RealEstateObjects realEstateObjects = new RealEstateObjects();
        realEstateObjects.setRealEstateObjects(new ArrayList<>(DB.values()));
        return realEstateObjects;
    }


    /**
     * Creates a new real estate object.
     *
     * @param realEstateObject
     * @return 400 / 201 HTTP responses depending on the result
     * @throws URISyntaxException
     */
    @POST
    @Consumes("application/json")
    public Response createRealEstateObject(RealEstateObject realEstateObject) throws URISyntaxException
    {
        if(realEstateObject.getType() == null || realEstateObject.getPrice() <= 0 || realEstateObject.getAddress() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        realEstateObject.setId(DB.values().size() + 1);
        realEstateObject.setUri("/real-estate-object-management/" + realEstateObject.getId());
        DB.put(realEstateObject.getId(), realEstateObject);
        return Response.status(201).contentLocation(new URI(realEstateObject.getUri())).build();
    }


    /**
     * Gets real estate object by its ID.
     *
     * @param id
     * @return 404 / 200 HTTP responses depending on the result
     * @throws URISyntaxException
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getRealEstateObjectById(@PathParam("id") int id) throws URISyntaxException
    {
        RealEstateObject realEstateObject = DB.get(id);
        if(realEstateObject == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(realEstateObject)
                .contentLocation(new URI("/real-estate-object-management/" + id)).build();
    }

    /**
     * Updates real estate object which is selected by its ID.
     *
     * @param id
     * @param realEstateObject
     * @return 404 / 200 HTTP responses depending on the result
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUCar(@PathParam("id") int id, RealEstateObject realEstateObject)
    {
        RealEstateObject temp = DB.get(id);
        if(realEstateObject == null) {
            return Response.status(404).build();
        }
        temp.setType(realEstateObject.getType());
        temp.setPrice(realEstateObject.getPrice());
        temp.setAddress(realEstateObject.getAddress());
        temp.setSquareMeters(realEstateObject.getSquareMeters());
        temp.setNumberOfFloors(realEstateObject.getNumberOfFloors());
        temp.setWater(realEstateObject.isWater());
        temp.setGas(realEstateObject.isGas());
        temp.setElectricity(realEstateObject.isElectricity());
        temp.setSewerage(realEstateObject.isSewerage());
        DB.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }

    /**
     * Deletes real estate object which is selected by its ID.
     *
     * @param id
     * @return 404 / 200 HTTP responses depending on the result
     */
    @DELETE
    @Path("/{id}")
    public Response deleteRealEstateObject(@PathParam("id") int id) {
        RealEstateObject realEstateObject = DB.get(id);
        if(realEstateObject != null) {
            DB.remove(realEstateObject.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    /**
     * Testing data.
     */
    static {
        RealEstateObject realEstateObject1 = new RealEstateObject();
        realEstateObject1.setId(1);
        realEstateObject1.setType("Butas");
        realEstateObject1.setPrice(100000);
        realEstateObject1.setAddress("Vilniaus g. 1, Vilnius");
        realEstateObject1.setSquareMeters(75.50f);
        realEstateObject1.setNumberOfFloors(1);
        realEstateObject1.setWater(true);
        realEstateObject1.setGas(true);
        realEstateObject1.setElectricity(true);
        realEstateObject1.setSewerage(true);
        realEstateObject1.setUri("/real-estate-object-management/1");

        RealEstateObject realEstateObject2 = new RealEstateObject();
        realEstateObject2.setId(2);
        realEstateObject2.setType("Namas");
        realEstateObject2.setPrice(200000);
        realEstateObject2.setAddress("Verkiu g. 75, Vilnius");
        realEstateObject2.setSquareMeters(175.70f);
        realEstateObject2.setNumberOfFloors(2);
        realEstateObject2.setWater(true);
        realEstateObject2.setGas(true);
        realEstateObject2.setElectricity(true);
        realEstateObject2.setSewerage(true);
        realEstateObject2.setUri("/real-estate-object-management/2");

        RealEstateObject realEstateObject3 = new RealEstateObject();
        realEstateObject3.setId(3);
        realEstateObject3.setType("Kotedzas");
        realEstateObject3.setPrice(140000);
        realEstateObject3.setAddress("Justiniskiu g. 50, Vilnius");
        realEstateObject3.setSquareMeters(120.50f);
        realEstateObject3.setNumberOfFloors(2);
        realEstateObject3.setWater(true);
        realEstateObject3.setGas(true);
        realEstateObject3.setElectricity(true);
        realEstateObject3.setSewerage(true);
        realEstateObject3.setUri("/real-estate-object-management/3");

        RealEstateObject realEstateObject4 = new RealEstateObject();
        realEstateObject4.setId(4);
        realEstateObject4.setType("Garazas");
        realEstateObject4.setPrice(15000);
        realEstateObject4.setAddress("Plytines g. 1, Vilnius");
        realEstateObject4.setSquareMeters(15.20f);
        realEstateObject4.setNumberOfFloors(1);
        realEstateObject4.setWater(false);
        realEstateObject4.setGas(false);
        realEstateObject4.setElectricity(true);
        realEstateObject4.setSewerage(false);
        realEstateObject4.setUri("/real-estate-object-management/4");

        DB.put(realEstateObject1.getId(), realEstateObject1);
        DB.put(realEstateObject2.getId(), realEstateObject2);
        DB.put(realEstateObject3.getId(), realEstateObject3);
        DB.put(realEstateObject4.getId(), realEstateObject4);
    }
}
