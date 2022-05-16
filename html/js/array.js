let parentesPesssoaEspecifica = ["Tio1", "Tio2", "Tio3"];

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.push("Tio4");

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.push(["primo1", "primo2"]);

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.push(122);

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.pop();
parentesPesssoaEspecifica.pop();

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.shift();

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

parentesPesssoaEspecifica.unshift("Tio1");

console.log(parentesPesssoaEspecifica);
console.log(parentesPesssoaEspecifica.length);

let encontrado = parentesPesssoaEspecifica.indexOf("Tio3");
let encontrado2 = parentesPesssoaEspecifica.indexOf("Tio31");

console.log(encontrado);
console.log(encontrado2);

let encontrado3 = parentesPesssoaEspecifica.includes("Tio3");

console.log(encontrado3);

parentesPesssoaEspecifica.splice(encontrado, 1);

console.log(parentesPesssoaEspecifica);

let copia = parentesPesssoaEspecifica.slice();

console.log(copia);
