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
	$('#Scene10_Title').addClass('visible');
	$('#Scene10_Chart').addClass('visible');
	
	$('#Scene10_Bar1').addClass('visible');
    $('#Scene10_Bar2').addClass('visible');
    $('#Scene10_Bar3').addClass('visible');
    $('#Scene10_Bar4').addClass('visible');
    $('#Scene10_Bar5').addClass('visible');
    $('#Scene10_Bar6').addClass('visible');
	$('#Scene10_Bar7').addClass('visible');
	$('#Scene10_Bar8').addClass('visible');
	$('#Scene10_Bar9').addClass('visible');
	
	$('#Scene10_Bar3R').addClass('visible');
	$('#Scene10_Bar5R').addClass('visible');
	$('#Scene10_Bar6R').addClass('visible');
	$('#Scene10_Bar9R').addClass('visible');
	
	$('#Scene10_Bar1_Text').addClass('visible');
    $('#Scene10_Bar2_Text').addClass('visible');
    $('#Scene10_Bar3_Text').addClass('visible');
    $('#Scene10_Bar4_Text').addClass('visible');
    $('#Scene10_Bar5_Text').addClass('visible');
    $('#Scene10_Bar6_Text').addClass('visible');
	$('#Scene10_Bar7_Text').addClass('visible');
	$('#Scene10_Bar8_Text').addClass('visible');
	$('#Scene10_Bar9_Text').addClass('visible');
	
	$('#Scene10_Footer1').addClass('visible');
	$('#Scene10_Footer2').addClass('visible');
	
	
    $('#Scene_H1').addClass('visible');
    $('#Scene_H2').addClass('visible');
    $('#Scene_H3').addClass('visible');
    $('#Scene_H4').addClass('visible');
    $('#Scene_H5').addClass('visible');
    $('#Scene_H6').addClass('visible');
    $('#Scene_H7').addClass('visible');
    
    
    $('#Scene10_Header1').addClass('visible');
    $('#Scene10_Header2').addClass('visible');
    
    
    
    $('#Scene10_Label').addClass('visible');
    
    $('#Scene10_Logo').addClass('visible');
    

/*popup 1*/
    $('#Ref').bind('touchend', function(event) {      
       $('#slide10_popup1').addClass('visible'); 
       $('#background_transparent1').addClass('visible');
       $('#background_Frame1').addClass('visible');
       return false;
     });
     $('#slide10_popup1').bind('touchend', function(event) {      
       document.getElementById('slide10_popup1').className='reset_slide10_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
        
     $('#background_transparent1').bind('touchend', function(event) {      
         document.getElementById('slide10_popup1').className='reset_slide10_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });
      $('#background_Frame1').bind('touchend', function(event) {      
        document.getElementById('slide10_popup1').className='reset_slide10_popup1';
         document.getElementById('background_transparent1').className='resetBackground_Transparent1';
         document.getElementById('background_Frame1').className='reset_background_Frame1';
      });   
	   
/*popup */
    $('#Study1').bind('touchend', function(event) {      
       $('#slide10_popup2').addClass('visible'); 
       $('#background_transparent2').addClass('visible');
       $('#background_Frame2').addClass('visible');
       return false;
     });
     $('#slide10_popup2').bind('touchend', function(event) {      
       document.getElementById('slide10_popup2').className='reset_slide10_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
      });
        
     $('#background_transparent2').bind('touchend', function(event) {      
         document.getElementById('slide10_popup2').className='reset_slide10_popup2';
         document.getElementById('background_transparent2').className='resetBackground_Transparent2';
         document.getElementById('background_Frame2').className='reset_background_Frame2';
      });
	  
      $('#background_Frame2').bind('touchend', function(event) {      
        document.getElementById('slide10_popup2').className='reset_slide10_popup2';
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
            window.location = "9.html";
        }
        if ( dL > 40 && touchLength == 1 && moveFlag == 1){
            window.location = "11.html";
        }
    }, false);
});