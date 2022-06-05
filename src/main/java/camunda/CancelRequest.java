package camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class CancelRequest implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Long userId = (Long) delegateExecution.getVariable("userId");
        Long orchestraId = (Long) delegateExecution.getVariable("orchestraId");
        System.out.println("Canceled request for user(" + userId + ") and orchestra(" + orchestraId + ")");
    }
}

