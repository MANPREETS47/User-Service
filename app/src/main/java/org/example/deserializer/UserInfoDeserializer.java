package org.example.deserializer;

import org.apache.kafka.common.serialization.Deserializer;
import org.example.entities.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoDeserializer implements Deserializer<UserInfo> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserInfo deserialize(String topic, byte[] data) {
        if (data == null) return null;  // ✅ Handle null safely
        try {
            return objectMapper.readValue(data, UserInfo.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize UserInfo", e);
        }
    }
}