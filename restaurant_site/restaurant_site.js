function validateName() {
    var name = document.forms["ContactForm"]["FullName"].value;
	var email = document.forms["ContactForm"]["email"].value;
	var phone = document.forms["ContactForm"]["phone"].value;
	var reason = document.forms["ContactForm"]["reason"].value;
	var info = document.forms["ContactForm"]["info"].value;
	var questionnaire = document.forms["ContactForm"]["questionnaire"].value;
	var monday = document.forms["ContactForm"]["Monday"].checked;
	var tuesday = document.forms["ContactForm"]["Tuesday"].checked;
	var wednesday = document.forms["ContactForm"]["Wednesday"].checked;
	var thursday = document.forms["ContactForm"]["Thursday"].checked;
	var friday = document.forms["ContactForm"]["Friday"].checked;
    if (name != "" && email != "" && phone != "" && reason != "" && info != "" && questionnaire != "" && (monday != false || tuesday != false || wednesday != false || thursday != false || friday != false)) {
        alert("Information is valid");
		
    } else {
		alert("Information is not valid. Please fill in the fields");
}
}
