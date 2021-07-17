const app = new Vue({
    el:'#obs',
    data:{
        username:localStorage.getItem("usuario"),
        cod_obs:localStorage.getItem("cod_obs"),
        observaciones:[],
        obs:{},
        comentarios:[],
        nuevoComentario:"",
        nuevoComConf:"",
        resuelta:"",
    },
    methods:{
        verObservacion:function(){
            this.informeBand=false;
            this.listaBand=true;

            axios.post('/obtenerObservacion',{ id: this.cod_obs }).then(response => (this.obs = response.data));
        },
        verComentarios:function(){
            axios.post('/obtenerComentario',{ id: this.cod_obs }).then(response => (this.comentarios = response.data));
        },
        responderComentario:function(){
            axios.post('/responderComentario',{ contenido: this.nuevoComentario,username:this.username,id_observacion:this.cod_obs }).then(response => (this.nuevoComConf= response.data));
            this.comentarios.push({username:"Yo",contenido:this.nuevoComentario,orden:'1',fecha:'Hoy',hora:'Ahora mismo'});
            this.nuevoComentario=""
        },
        marcarResuelto:function(){
            axios.post('/marcarResuelta',{ id: this.cod_obs }).then(response => (this.resuelta = response.data));
            this.verObservacion;
        }
    },
    mounted () {
        this.verObservacion();
        this.verComentarios()
    },
})