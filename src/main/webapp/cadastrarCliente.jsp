<%-- 
    Document   : vender
    Created on : Mar 29, 2018, 12:13:17 PM
    Author     : paulo.bezerra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
        <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="topodapagina.css" rel="stylesheet">


    <form name = "cadastrarCliente" action="${pageContext.request.contextPath}/cadastrarCliente" method="POST" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vender</title>

    </head>
    <body id="page-top">
        <form>
            <div id="includedContent"></div>

            <%@include  file="navbar.jsp" %>


            <div align ="center">
                <br>

                <div class="container">
                    <div class="py-5 text-center">
                        <!--img class="d-block mx-auto mb-4" src="img/LogoPetMaster.png" alt="" width="200" height="200"-->
                        <h2>Cadastrar Cliente</h2>
                    </div>
                </div>


                <div class="col-md-8 order-md-1">

                    <div class="mb-3">
                        <label for="cpf">CPF do cliente</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"></span>
                            </div>

                            <input onkeydown="javascript: fMasc(this, mCPF);" type="text" class="form-control" id="cpf" name="cpfcliente" maxlength="14" placeholder="000.000.000-00" required>

                            <div class="invalid-feedback" style="width: 100%;">
                                CPF obrigatório.
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="rg">RG do cliente</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"></span>
                            </div>

                            <input  onkeydown="javascript: fMasc(this, mRG);" type="text" class="form-control" id="rg" name="rgcliente" maxlength="12" placeholder="00.000.000-0" value ="" required>

                            <div class="invalid-feedback" style="width: 100%;">
                                RG obrigatório.
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="primeironome">Nome</label>
                        <div class="input-group">
                            <input name="nomecliente" type="text" class="form-control" id="nomecliente" placeholder="" value="" name="nomecliente" required>
                            <div class="invalid-feedback">
                                Primeiro nome necessário
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email <span class="text-muted">(Opcional)</span></label>
                        <input name ="email" type="email" class="form-control" id="email" placeholder="voce@exemplo.com" value ="">
                        <div class="invalid-feedback">
                            Favor inserir um email válido para o frete.
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="endereco">Rua</label>
                        <input name ="logradouro" type="text" class="form-control" id="endereco" placeholder="Rua hum 1234" value=""required>
                        <div class="invalid-feedback">
                            Favor inserir seu endereço de envio.
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="bairro">Bairro</label>
                        <input name ="bairro" type="text" class="form-control" id="bairro" placeholder="Bairro" value=""required>
                        <div class="invalid-feedback">
                            Favor inserir o Bairro.
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="cidade">Cidade</label>
                        <input name ="cidade" type="text" class="form-control" id="cidade" placeholder="Cidade" value=""required>
                        <div class="invalid-feedback">
                            Favor inserir a Cidade.
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label >País</label>
                            <select name ="pais" class="custom-select d-block w-100" id="pais" required>
                                <option>Brasil</option>
                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar o país.
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label  for="estado">Estado</label>
                            <select name = "estado" class="custom-select d-block w-100" id="estado" value = "" required>
                                <option>São Paulo</option>
                                <option>Rio de Janeiro</option>
                                <option>São Paulo</option>
                                <option>São Paulo</option>
                                <option>São Paulo</option>
                                <option>São Paulo</option>

                            </select>

                            <div class="invalid-feedback">
                                Favor selecionar um Estado..
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cep">CEP</label>
                            <input name ="cep" type="text" class="form-control" id="cep" onkeydown="javascript: fMasc(this, mCEP);" placeholder="00000-000" maxlength="10" value = "" required>
                            <div class="invalid-feedback">
                                CEP obrigatório
                            </div>
                        </div>
                        <div class="col-md-2 mb-3">
                            <label name ="sexo" >UF</label>
                            <select name ="uf" class="custom-select d-block w-100" id="sexo" value = "" required>
                                <option>SP</option>
                                <option>RJ</option>
                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar a UF
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="telefone">Telefone</label>
                            <input onkeydown="javascript: fMasc(this, mTel);" name = "telefone" type="text" class="form-control" id="tel" placeholder="(xx)xxxxx-xxxx" maxlength="14" value = "">
                            <div class="invalid-feedback">
                                Telefone obrigatório
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="celular">Celular</label>
                            <input onkeydown="javascript: fMasc(this, mTel);" name ="celular" type="text" class="form-control" id="cel" placeholder="(xx)xxxxx-xxxx" maxlength="14" value = "" required>
                            <div class="invalid-feedback">
                                Celular obrigatório
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label name ="sexo" >Sexo</label>
                            <select class="custom-select d-block w-100" id="sexo" value = "" required>
                                <option selected>Selecionar...</option>
                                <option>Masculino</option>
                                <option>Feminino</option>
                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar o Sexo
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label  >Estado Civil</label>
                            <select name ="estadocivil" class="custom-select d-block w-100" id="sexo" value = "" required>
                                <option selected>Selecionar...</option>
                                <option>Solteiro</option>
                                <option>Casado</option>
                                <option>Divorciado</option>
                            </select>
                            <div class="invalid-feedback">
                                Favor selecionar o Estado Civil
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="nascimento">Nascimento</label>
                            <input name = "nascimento" type="date" class="form-control" id="cep" placeholder="dd/mm/aaaa" maxlength="10" value = "" required>
                            <div class="invalid-feedback">
                                Nascimento obrigatório
                            </div>
                        </div>

                        <hr class="mb-4">
                        <button class="btn btn-primary btn-lg btn-block" type="submit" name = "gravarcliente">Gravar</button>
                    </div>
                </div>

                <footer class="my-5 pt-5 text-muted text-center text-small">
                    <p class="mb-1">&copy; Javazeiros - Projeto Semestre 3</p>
                    <ul class="list-inline">
                        <li class="list-inline-item"><a href="#">Privacidade</a></li>
                        <li class="list-inline-item"><a href="#">Termos</a></li>
                        <li class="list-inline-item"><a href="https://www.google.com">Suporte</a></li>
                    </ul>
                </footer>
            </div>

        </form>




        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
        <script src="../../../../assets/js/vendor/popper.min.js"></script>
        <script src="../../../../dist/js/bootstrap.min.js"></script>
        <script src="../../../../assets/js/vendor/holder.min.js"></script>

        <script>
                                // Example starter JavaScript for disabling form submissions if there are invalid fields
                                (function () {
                                    'use strict';

                                    window.addEventListener('load', function () {
                                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                        var forms = document.getElementsByClassName('needs-validation');

                                        // Loop over them and prevent submission
                                        var validation = Array.prototype.filter.call(forms, function (form) {
                                            form.addEventListener('submit', function (event) {
                                                if (form.checkValidity() === false) {
                                                    event.preventDefault();
                                                    event.stopPropagation();
                                                }
                                                form.classList.add('was-validated');
                                            }, false);
                                        });
                                    }, false);
                                }
                                )();


        </script>

        <script type="text/javascript">
            function fMasc(objeto, mascara) {
                obj = objeto
                masc = mascara
                setTimeout("fMascEx()", 1)
            }
            function fMascEx() {
                obj.value = masc(obj.value)
            }
            function mTel(tel) {
                tel = tel.replace(/\D/g, "")
                tel = tel.replace(/^(\d)/, "($1")
                tel = tel.replace(/(.{3})(\d)/, "$1)$2")
                if (tel.length == 9) {
                    tel = tel.replace(/(.{1})$/, "-$1")
                } else if (tel.length == 10) {
                    tel = tel.replace(/(.{2})$/, "-$1")
                } else if (tel.length == 11) {
                    tel = tel.replace(/(.{3})$/, "-$1")
                } else if (tel.length == 12) {
                    tel = tel.replace(/(.{4})$/, "-$1")
                } else if (tel.length > 12) {
                    tel = tel.replace(/(.{4})$/, "-$1")
                }
                return tel;
            }
            function mCNPJ(cnpj) {
                cnpj = cnpj.replace(/\D/g, "")
                cnpj = cnpj.replace(/^(\d{2})(\d)/, "$1.$2")
                cnpj = cnpj.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3")
                cnpj = cnpj.replace(/\.(\d{3})(\d)/, ".$1/$2")
                cnpj = cnpj.replace(/(\d{4})(\d)/, "$1-$2")
                return cnpj
            }
            function mCPF(cpf) {
                cpf = cpf.replace(/\D/g, "")
                cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
                cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
                cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2")
                return cpf
            }
            function mRG(rg) {
                rg = rg.replace(/\D/g, "")
                rg = rg.replace(/(\d{2})(\d)/, "$1.$2")
                rg = rg.replace(/(\d{3})(\d)/, "$1.$2")
                rg = rg.replace(/(\d{3})(\d{1})$/, "$1-$2")
                return rg
            }
            function mCEP(cep) {
                cep = cep.replace(/\D/g, "")
                cep = cep.replace(/^(\d{2})(\d)/, "$1.$2")
                cep = cep.replace(/\.(\d{3})(\d)/, ".$1-$2")
                return cep
            }
            function mNum(num) {
                num = num.replace(/\D/g, "")
                return num
            }
        </script>
        
            <script>


        var resultado = "${resultado}"

        var cpfcliente = "${cpfcliente}"


        if (resultado == "CPF já está Cadastrado") {
            alert(resultado)

        } else if (resultado == "Cliente Cadastrado") {
            
            alert(resultado+" para o CPF"+cpfcliente)

        }



    </script>

    </body>
</html>
