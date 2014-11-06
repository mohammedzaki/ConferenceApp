$(document).ready(function () {     
    
	$('#Menu').bind('touchend', function(event) {  
	    if(menuOpened == false){
           $('#Menu').addClass('visible');
		   $('#Menu1').addClass('visible');
		   $('#Menu2').addClass('visible');
		   $('#Menu3').addClass('visible');
           menuOpened = true ;
		}else{
           document.getElementById('Menu').className='CloseMenu';
		   document.getElementById('Menu1').className='CloseMenu';
		   document.getElementById('Menu2').className='CloseMenu';
		   document.getElementById('Menu3').className='CloseMenu';
		   menuOpened = false ;
        }		
    });
	
	$('#Menu1').bind('touchend', function(event) {            
        window.location = "index-2.html";
    });
    $('#Menu2').bind('touchend', function(event) {            
        window.location = "2.html";
    });
    $('#Menu3').bind('touchend', function(event) {            
        window.location = "9.html";
    });
    $('#Scene_Home').bind('touchend', function(event) {  
        window.location = "index-2.html";
    });
	$('#Scene_Arrow').bind('touchend', function(event) {            
        window.location = "Master.html";
    });

	
	$('#Ref').addClass('visible');
	$('#Sat').addClass('visible');
	$('#Study1').addClass('visible');
	
    $('#Scene6_0').addClass('visible');
	$('#Scene6_1').addClass('visible');
	$('#Scene6_2').addClass('visible');
    $('#Scene6_3').addClass('visible');
	$('#Scene6_4').addClass('visible');
	$('#Scene6_5').addClass('visible');
    $('#Scene6_6').addClass('visible');
	$('#Scene6_7').addClass('visible');
	$('#Scene6_8').addClass('visible');
	$('#Scene6_9').addClass('visible');
    $('#Scene6_10').addClass('visible');
	$('#Scene6_11').addClass('visible');
	$('#Scene6_12').addClass('visible');
	$('#Scene6_13').addClass('visible');
	$('#Scene6_14').addClass('visible');
    $('#Scene6_15').addClass('visible');
	$('#Scene6_16').addClass('visible');
	$('#Scene6_17').addClass('visible');
	$('#Scene6_18').addClass('visible');
	$('#Scene6_19').addClass('visible');
	$('#Scene6_20').addClass('visible');
	$('#Scene6_21').addClass('visible');
	$('#Scene6_22').addClass('visible');
	$('#Scene6_23').addClass('visible');
	$('#Scene6_24').addClass('visible');
	$('#Scene6_25').addClass('visible');
	$('#Scene6_26').addClass('visible');
	$('#Scene6_27').addClass('visible');
	$('#Scene6_28').addClass('visible');
	$('#Scene6_29').addClass('visible');


/*popup 1*/
    $('#Ref').bind('touchend', function(event) {      
       $('#slide6_popup1').addClass('visible'); 
       $('#background_transparent1').addClass('visible');
       $('#background_Frame1').addClass('visible');
       return false;
     });
     $('#slide6_popup1').bind('touchend', function(event) {      
       document.getElementById('slide6_popup1').className='reset_slide6_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
        
     $('#background_transparent1').bind('touchend', function(event) {      
         document.getElementById('slide6_popup1').className='reset_slide6_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
      $('#background_Frame1').bind('touchend', function(event) {      
        document.getElementById('slide6_popup1').className='reset_slide6_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });   
	   
/*popup */
    $('#Sat').bind('touchend', function(event) {      
       $('#slide6_popup2').addClass('visible'); 
       $('#background_transparent2').addClass('visible');
       $('#background_Frame2').addClass('visible');
       return false;
     });
     $('#slide6_popup2').bind('touchend', function(event) {      
       $('#background_transparent2').click();
      });
        
     $('#background_transparent2').bind('touchend', function(event) {      
         document.getElementById('slide6_popup2').className='reset_slide6_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
      });
	  
      $('#background_Frame2').bind('touchend', function(event) {      
        $('#background_transparent2').click();
      });   	       
	
	
	
	
	
	
	
    document.body.addEventListener('touchstart', function(e) {  //touchstart mousedown
       touchLength = event.touches.length; 
       if (touchLength != 2){
           e.preventDefault();
       }
       moveFlag = 0;
       startX = e.pageX ;
    }, false);

    document.body.addEventListener('touchmove', function(e) { //touchmove mousemove
       moveFlag = 1 ;
       endX = e.pageX ;
    }, false);
    
    document.body.addEventListener('touchend', function(e) { //touchend mouseup
       dR = endX-startX ;
       dL = startX-endX ;
        if ( dR > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "5.html";
        }
        if ( dL > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "7.html";
        }
    }, false);
});