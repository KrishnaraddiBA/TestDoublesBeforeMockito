package org.example.dummyTestDoubleTesting;

import org.example.dummyTestdoubletesting.EmailService;

public class FakeEmailSendingService implements EmailService {

    @Override
    public void sendMessage(String message) {
        throw new AssertionError("method not implemented successfully!!");
    }
}
