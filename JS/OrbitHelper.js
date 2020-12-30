/* === 🌌 WELCOME TO ORBIT JS HELPER SPACESHIP 🌌  ===
*
*	  Project : ORIENTA
*	  By :
*
*     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗
*    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
*    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
*    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
*    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
*     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
*
*  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal
*                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/
*/

/**
 * Object that Allows user to make the Browser Speak a given text
 * It Is Fully Parametrable
 *
 * @type {{speak: (function(*=): (void|undefined))}}
 */
OrbitSpeech = {
  speak : function (message) {
    if (typeof message != 'string'){
      return console.log("OrbitSpeechHelper Error 001 : \n Provided Parameter message isn't a String");
    }
    // We created a variable msg, and the value assigned to it is a new instance of the speechSynthesis class.
    let msg = new SpeechSynthesisUtterance();

    // The .text property is used to specify the text we want to convert to speech
    msg.text = message;

    // It is what actually make our browser talks.
    window.speechSynthesis.speak(msg);

    // All possible Option
    /*msg.voice = voices[10];
    msg.volume = 1; // From 0 to 1
    msg.rate = 1; // From 0.1 to 10
    msg.pitch = 2; // From 0 to 2
    msg.text = "Como estas Joel";
    msg.lang = 'es';*/

    // The code below helps you retrieve the list of all supported voices:
    // speechSynthesis.getVoices().forEach(function(voice) {
    //   console.log(voice.name, voice.default ? voice.default :'');
    // });
  }
}
