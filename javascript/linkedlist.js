function Node(value, next) {
  this.value = value;
  this.next = next;
}

function abc() {

}

const test = new Node(1);
let current = test
for (let i = 2; i <= 11; i++) {
  current.next = new Node(i);
  current = current.next;
}