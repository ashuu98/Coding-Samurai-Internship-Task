var stompClient = null;

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public', function (message) {
            showMessage(JSON.parse(message.body));
        });
        stompClient.send("/app/chat.addUser", {}, JSON.stringify({
            sender: document.getElementById('username').value,
            type: 'JOIN'
        }));
    }, function (error) {
        console.log('Error: ' + error);
    });
}

function sendMessage() {
    var messageContent = document.getElementById('message').value;
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: document.getElementById('username').value,
            content: messageContent,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        document.getElementById('message').value = '';
    }
}

function showMessage(message) {
    var messages = document.getElementById('chat-messages');
    var messageElement = document.createElement('div');
    messageElement.classList.add('message');
    if (message.type === 'JOIN') {
        messageElement.classList.add('join');
        messageElement.textContent = message.sender + ' joined!';
    } else if (message.type === 'CHAT') {
        messageElement.textContent = message.sender + ': ' + message.content;
    }
    messages.appendChild(messageElement);
    messages.scrollTop = messages.scrollHeight;
}

document.getElementById('send-btn').addEventListener('click', sendMessage);
document.getElementById('message').addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
        sendMessage();
    }
});

// Connect on page load
window.onload = function() {
    connect();
};