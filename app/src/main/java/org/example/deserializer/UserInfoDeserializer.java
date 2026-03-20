package org.example.deserializer;

import org.apache.kafka.common.serialization.Deserializer;
import org.example.entities.UserInfo;
import org.example.model.UserInfoDto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoDeserializer implements Deserializer<UserInfo> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserInfo deserialize(String topic, byte[] data) {
        if (data == null) return null;
        try {
            String json = new String(data);
            ObjectMapper mapper = new ObjectMapper();
            com.fasterxml.jackson.databind.JsonNode node = mapper.readTree(json);
            UserInfo userInfo = new UserInfo();
            if (node.has("id")) {
                userInfo.setUserId(node.get("id").asText());
            }
            if (node.has("first_name")) {
                userInfo.setFirstName(node.get("first_name").asText());
            }
            if (node.has("last_name")) {
                userInfo.setLastName(node.get("last_name").asText());
            }
            if (node.has("phone_number")) {
                userInfo.setPhoneNumber(node.get("phone_number").isNull() ? null : node.get("phone_number").asLong());
            }
            if (node.has("email")) {
                userInfo.setEmail(node.get("email").asText());
            }
            if (node.has("profile_pic")) {
                userInfo.setProfilePic(node.get("profile_pic").asText());
            }
            return userInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}