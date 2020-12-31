package control;

import java.util.ArrayList;
import java.util.List;

public class ActionErrors {
List<ActionError> errors = new ArrayList<ActionError>();

public List<ActionError> getErrors() {
	return errors;
}

public void setErrors(ActionError error) {
	errors.add(error);
}
}
