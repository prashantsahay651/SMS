$(document).ready( function() {
        $('#snackbar1').delay(5000).fadeOut();
      	  var checkbox = $("#trigger");
      	  var hidden = $("#hidden_fields");
      	  var populate = $("#populate");
      	  hidden.show();
      	  checkbox.change(function() {
      	    if (checkbox.is(':checked')) {
      	      // Show the hidden fields.
      	      hidden.hide();
      	      // Populate the input.
      	      populate.val("Dude, this input got populated!");
      	    } else {
      	      hidden.show();
      	    }
      	  });
      
      
      });



