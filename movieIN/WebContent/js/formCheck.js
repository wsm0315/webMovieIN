function formCheck(FORM) {
	if (FORM.submitted) 
		return false;
	FORM.method = "post";
	FORM.submitted = true;
	return true;
}