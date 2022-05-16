let texto = "Qualquer texto";
let texto2 = "segunda parte";

//let resumo = texto + " " + texto2;
let exemploTexto = `Qualquer texto que eu queira ${texto2} para testar ${ 1 + 1 }`;
let resumo = `${texto} ${texto2}`;

console.log(exemploTexto);
console.log(resumo);

/* let listaDeFrutas = "Lista de Frutas:" +
                    "\n" +
                    "- Banana" +
                    "\n" +
                    "- Mamão" +
                    "\n" +
                    "- Maça"; */

let listaDeFrutas = 
`Lista de Frutas:
- Banana
- Mamão
- Maça`;

console.log(listaDeFrutas);

console.log(exemploTexto.startsWith('quer', 4));
console.log(exemploTexto.endsWith('testar', 54));
console.log(exemploTexto.includes('queira'));
console.log(texto2.repeat(4));