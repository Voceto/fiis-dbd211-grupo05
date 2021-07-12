const app = new Vue({
    el:'#inicio_ses',
    data:{
        usuarioRequest:{username:""} 
    },
    methods:{
        inicioSesion:function(){
            localStorage.setItem("usuario",this.usuarioRequest.username);
        }
    },
})