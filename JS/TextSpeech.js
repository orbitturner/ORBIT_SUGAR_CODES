var msg = new SpeechSynthesisUtterance();
msg.text = "Votre parcours doit comporter au moins 4 activités " +
  "et toutes vos activités doivent être approuvées par au moins un justificatif " +
  "(Bulletins des deux semestres ou Diplome de l'année).";
window.speechSynthesis.speak(msg);