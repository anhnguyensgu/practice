(function solve() {

  function splitMessage(longMessage, limit) {
    const messages = longMessage.split(" ");
    let result = 0;
    let sum = 0;
    let message = '';
    for (let i = 0; i < messages.length; i++) {
      if (messages[i].length > limit) return -1;
      
      const currentSum = sum === 0 ? (sum + messages[i].length) : (sum + messages[i].length + 1);
      const currentMessage = message + ' ' + messages[i];
      if (currentSum > 0 && currentSum <= limit) {
        sum = currentSum;
        message = currentMessage;
      } else {
        sum = messages[i].length;
        console.log(message.trim());
        message = messages[i];
        result++;
      }
    }
    if (message.length > 0) {
      result++; 
      console.log(message.trim());
    }

    return result;
  }
  console.log('-------\nnumber of messages: ',splitMessage("SMS messages are splitted", 10));
})();