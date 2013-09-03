package org.openmrs.module.muzimaregistration.handler;

import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.openmrs.module.muzima.model.QueueData;

/**
 * Give brief description for this class
 */
public class RegistrationQueueDataHandlerTest {
    private static String registrationJson;

    /**
     * @verifies handle the only queue data with matching discriminator
     * @see RegistrationQueueDataHandler#accept(org.openmrs.module.muzima.model.QueueData)
     */
    @Test
    public void accept_shouldHandleTheOnlyQueueDataWithMatchingDiscriminator() throws Exception {
        QueueData queueData = new QueueData();
        queueData.setDiscriminator("tbdata");

        Boolean actualResult = new RegistrationQueueDataHandler().accept(queueData);

        Assert.assertTrue("Invalid Discriminator", actualResult == false);
    }

    /**
     * @verifies throw exception on invalid payload structure
     * @see RegistrationQueueDataHandler#accept(org.openmrs.module.muzima.model.QueueData)
     */
    @Test
    public void accept_shouldThrowExceptionOnInvalidPayloadStructure() throws Exception {

        JSONObject registrationObject = new JSONObject();
        registrationObject.put("dataSource", "da2a1c5a-04a6-4070-b2ca-81b57e1ab928");
        registrationObject.put("discriminator", "registration");
        JSONObject payloadObject = new JSONObject();
        payloadObject.put("patient.identifier", "9999-4");
        payloadObject.put("patient.identifier_type", "58a46e2e-1359-11df-a1f1-0026b9348838");
        payloadObject.put("patient.identifier_location", "c0937b97-1691-11df-97a5-7038c432aabf");
        payloadObject.put("patient.uuid", "6e698d66-9f59-4a3b-b3d7-91efb7b297d3");
        payloadObject.put("patient.birthdate", "1984-04-16 06:15:00");
        payloadObject.put("patient.birthdate_estimated", "false");
        payloadObject.put("patient.given_name", "Example");
        payloadObject.put("patient.middle_name", "of");
        payloadObject.put("patient.family_name", "Patient");
        payloadObject.put("patient.gender", "M");
        payloadObject.put("person_address.address1", "Adress 1");
        payloadObject.put("person_address.address2", "Adress 2");
        registrationObject.put("payload", payloadObject);
        registrationJson = registrationObject.toJSONString();

        QueueData queueData = new QueueData();
        queueData.setPayload(registrationJson);


        Assert.fail(new RegistrationQueueDataHandler().process(queueData));
    }

    /**
     * @verifies successfuly create data on valid payload structure
     * @see RegistrationQueueDataHandler#accept(org.openmrs.module.muzima.model.QueueData)
     */
    @Test
    public void accept_shouldSuccessfulyCreateDataOnValidPayloadStructure() throws Exception {
        //TODO auto-generated
        Assert.fail("Not yet implemented");
    }
}
