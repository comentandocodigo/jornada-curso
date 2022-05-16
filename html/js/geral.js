//console.log("Aqui exibe mensagens");
//alert("Aqui exibe mensagens");

//teste1 = "Testando";

/*console.log(teste);

var teste = "Testando";

console.log(teste);

var teste = "Testando Nova instancia de teste";

console.log(teste);*/

//let, const

let teste = "Testando";

console.log(teste);

teste = "Testando Novo";

console.log(teste);

{
  let teste = "Testando dentro de outro escopo";

  console.log(teste);
}

/*************************************/

const testeConst = "Testando Const";

console.log(testeConst);

/*testeConst = "Testando Const Novo";

console.log(testeConst);*/

const testeObjeto = {
  nome: "Testando",
  idade: 30,
  profissao: "FulllStack"
};

console.log(testeObjeto);

Object.freeze( testeObjeto );

testeObjeto.idade = 32;

console.log(testeObjeto);

/***************************/

console.log("Explicando o fracamente tipado");

//Primitivo - number
let numeroQualquer = 122;

//Primitivo - string
numeroQualquer = "Mudei para string";

//Primitivo - boolean (Verdadeiro ou falso)
let estaNoLugar = false;

//Primitivo - null
let testandoNull = null;

//Primitivo - undefined
let testandoUndefined = undefined; //busca de api;

//Primitivo - object
let testandoObject = {
  nome: ""
};

/***********************/

//Logicos e aritmeticos

let soma = 1 + 1;
let diminuicao = 2 - 1;
let divisao = 10 / 2;
let multiplicacao = 3 * 3;

console.log( soma, diminuicao, divisao, multiplicacao );

soma++;

console.log(soma);

soma--;

console.log(soma);

/*****************************/
console.log("fracamente tipado");

let nomeSobrenome = "Marcos" + " " + "Henrique";

console.log(nomeSobrenome);

let testandoNumero = 1 + 1 + "1";
let testandoNumero1 = 1 + "1" + 1;
let testandoNumero2 = "1" + 1 + 1;

console.log( testandoNumero );
console.log( testandoNumero1 );
console.log( testandoNumero2 );

/**********************/
//let operador = valor;

//inclusivo && -> todas as condicoes tem que ser verdadeiras (Todos ou nada)
//exclusivo || (Ou) -> Uma ou outra tem que ser verdadeira (Um ou nada)

/* if (valor == valor1 || valor != valor1 && 
  valor > valor1 || valor < valor1 && valor <= valor1 ||
  valor >= valor1  ) {
  
} */


console.log(Math.PI);

console.log( Math.abs(-1) );
console.log( Math.ceil(3.23) );
console.log( Math.floor(3.23) );
console.log( Math.trunc( 5.23 ) );

//console.log( Math.log )

console.log("potencia e raiz");
console.log( Math.pow(10, 2) );
console.log( Math.sqrt(81) );
