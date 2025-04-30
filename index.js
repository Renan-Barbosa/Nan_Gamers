document.addEventListener("DOMContentLoaded", function (){
const btnComprarProduto= document.getElementById("btnComprar");
const btnCadastrarDados= document.getElementById("btnCadastrar");
let email= document.getElementById("Email");
let senha= document.getElementById("Senha");


btnCadastrarDados.addEventListener('click', () =>{
   
    if(email.value == '' && senha.value == ''){
      mostrarMensagem("Email ou senha invalidos!");
         }else{
      
      mostrarMensagem("Seja bem vindo!")
      }
    
  });
  btnComprarProduto.addEventListener("click", () => {

    
    mostrarMensagem("Compra adicionado ao carrinho!");
  })




  function mostrarMensagem(texto){
    alert(texto)
  }
})