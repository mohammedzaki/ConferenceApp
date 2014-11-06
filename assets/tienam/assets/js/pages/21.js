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
	$('#Study1').addClass('visible');
	
    $('#Scene21_0').addClass('visible');
	$('#Scene21_1').addClass('visible');
	$('#Scene21_2').addClass('visible');
    $('#Scene21_3').addClass('visible');
	$('#Scene21_4').addClass('visible');
	$('#Scene21_5').addClass('visible');
    $('#Scene21_6').addClass('visible');
	$('#Scene21_7').addClass('visible');


	$('#Ref').bind('touchend', function(event) {      
       $('#slide22_popup1').addClass('visible'); 
       $('#background_transparent1').addClass('visible');
       $('#background_Frame1').addClass('visible');
       return false;
     });
     $('#slide22_popup1').bind('touchend', function(event) {      
       document.getElementById('slide22_popup1').className='reset_slide22_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
        
     $('#background_transparent1').bind('touchend', function(event) {      
         document.getElementById('slide22_popup1').className='reset_slide22_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
      $('#background_Frame1').bind('touchend', function(event) {      
        document.getElementById('slide22_popup1').className='reset_slide22_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });   
	   
/*popup */

    $('#Study1').bind('touchend', function(event) {      
       $('#slide22_popup2').addClass('visible'); 
       $('#background_transparent2').addClass('visible');
       $('#background_Frame2').addClass('visible');
       return false;
     });
     $('#slide22_popup2').bind('touchend', function(event) {      
        document.getElementById('slide22_popup2').className='reset_slide22_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
      });
        
     $('#background_transparent2').bind('touchend', function(event) {      
         document.getElementById('slide22_popup2').className='reset_slide22_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
      });
	  
      $('#background_Frame2').bind('touchend', function(event) {      
         document.getElementById('slide22_popup2').className='reset_slide22_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
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
            window.location = "20.html";
        }
        if ( dL > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "22.html";
        }
    }, false);
});