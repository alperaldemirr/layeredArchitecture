package eCommerceDemo.core.verification;

import eCommerceDemo.verification.Verification;

public class VerificationManagerAdapter implements VerificationService{
    @Override
    public void verificationToSystem(String message) {
        Verification verification = new Verification();
        verification.verificationSystem(message);
    }
}
