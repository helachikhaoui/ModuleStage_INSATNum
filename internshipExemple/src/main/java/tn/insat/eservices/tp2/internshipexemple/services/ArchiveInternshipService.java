package tn.insat.eservices.tp2.internshipexemple.services;

import java.util.logging.Logger;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.FileValue;

/**
 * <p>This is an empty service implementation illustrating how to use a plain
 * Java Class as a BPMN 2.0 Service Task delegate.</p>
 */
public class ArchiveInternshipService implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(ArchiveInternshipService.class.getName());

    public void execute(DelegateExecution execution) throws Exception {

        Boolean shouldFail = (Boolean) execution.getVariable("shouldFail");
        FileValue internshipDocumentVar  = execution.getVariableTyped("internshipDocument");

        if(shouldFail != null && shouldFail) {
            throw new ProcessEngineException("Could not archive internship...");
        }
        else {
            LOGGER.info("\n\n  ... Now archiving internship "+execution.getVariable("internshipNumber")
                    +", filename: "+internshipDocumentVar.getFilename()+", sendMail: "+execution.getVariable("WsResponse")+" \n\n");
        }

    }

}
