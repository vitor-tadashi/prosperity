<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="pt-br">
    
    <head>
        
        <meta charset="UTF-8">
        <title>Cadastro de Candidato</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <c:import url="shared/stylesheet.jsp"></c:import>
        
    </head>
    <body>
            <c:import url="shared/dashboard.jsp"></c:import>
            
            <div id="main-container">
                <div id="breadcrumb">
                    <ul class="breadcrumb">
                        <li><i class="fa fa-home"></i><a href=""> Início</a></li>
                        <li class="active"> Cadastrar candidato</li>
                    </ul>
                </div><!--breadcrumb-->
                
                <!-- SOMENTE ALTERAR DAQUI PARA BAIXO -->
                
                <div class="padding-md">
                    <div class="row">
                        <div class="panel panel-default">
                            <div class="panel-heading">Informações do candidato</div>
                            <div class="panel-body">
                                <form class="form-border" id="formCadastro" novalidate="">
                                    <div class="panel-tab clearfix">
                                        <ul class="tab-bar wizard-demo" id="wizardDemo">
                                            <li class="active tab-verity"><a href="#first" data-toggle="tab"><i class="fa fa-user"></i> Inf. pessoais</a></li>
                                            <li class="tab-verity"><a href="#second" data-toggle="tab" class="text-success"><i class="fa fa-pencil"></i> Inf. acadêmicas</a></li>
                                            <li class="tab-verity"><a href="#third" data-toggle="tab" class="text-success"><i class="fa fa-briefcase"></i> Currículo</a></li>
                                        </ul>
                                    </div>
                                    <div class="panel-body">
                                        <div class="tab-content">
                                            <div class="tab-pane fade in active" id="first">
                                                <div class="row">
                                                    <div class="form-group col-md-4">
                                                        <label class="control-label" for="nome">Nome</label>
                                                        <input type="text" class="form-control" id="nome" data-required="true" placeholder="Informe seu nome" value="João da Silva">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="email" class="control-label">E-mail</label>
                                                        <input type="text" class="form-control" id="email" data-required="true" placeholder="email@dominio.com" value="joaosilva@verity.com.br">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="cpf" class="control-label">CPF</label>
                                                        <input type="text" class="form-control" id="cpf" data-required="true" placeholder="Informe seu CPF" value="123.456.789-10">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label for="rg" class="control-label">RG</label>
                                                        <input type="text" class="form-control" id="rg" data-required="true" value="12.345.678">
                                                    </div>
                                                    <div class="form-group col-md-2 col-sm-4">
                                                        <label for="dataNascimento" class="control-label">Data nascimento</label>
                                                        <input type="text" class="form-control" id="dataNascimento" data-required="true" value="01/01/2000">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label for="telefone" class="control-label">Telefone</label>
                                                        <input type="text" class="form-control" id="telefone" data-required="true" value="(99) 99999-9999">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label for="cep" class="control-label">CEP</label>
                                                        <input type="text" class="form-control" id="cep" data-required="true" value="12345-000">
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label for="endereco" class="control-label">Endereço</label>
                                                        <input type="text" class="form-control" id="endereco" data-required="true" value="Av. Brigadeiro Faria Lima">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label for="numero" class="control-label">Número</label>
                                                        <input type="text" class="form-control" id="numero" data-required="true" value="1768">
                                                    </div>
                                                    <div class="form-group col-md-2">
                                                        <label for="complemento" class="control-label">Complemento</label>
                                                        <input type="text" class="form-control" id="complemento">
                                                    </div>
                                                    <div class="form-group col-md-3">
                                                        <label for="estado" class="control-label">Estado</label>
                                                        <select class="form-control" id="estado" data-required="true">
                                                            <option value="">Selecione</option>
                                                            <option value="1" selected>Minas Gerais</option>
                                                            <option value="2">Paraná</option>
                                                            <option value="3">São Paulo</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-5">
                                                        <label for="cidade" class="control-label">Cidade</label>
                                                        <select class="form-control" id="cidade" data-required="true">
                                                            <option value="">Selecione</option>
                                                            <option value="1" selected>Belo Horizonte</option>
                                                            <option value="2">Curitiba</option>
                                                            <option value="3">São Paulo</option>
                                                            <option value="4">Campinas</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="second">
                                                <div class="form-group col-md-4">
                                                    <label for="curso">Curso</label>
                                                    <input type="text" class="form-control" id="curso" data-required="true" placeholder="Informe seu curso">
                                                </div>
                                                <div class="form-group col-md-5">
                                                    <label for="instituicao">Instituição</label>
                                                    <input type="text" class="form-control" id="instituicao" data-required="true" placeholder="Instituição">
                                                </div>
                                                
                                                <div class="form-group col-md-3">
                                                    <label for="tipoDeCurso">Tipo de curso</label>
                                                    <select class="form-control" id="tipoDeCurso">
                                                        <option value="0">Selecione</option>
                                                        <option value="1">Formação Escolar Fundamental (1°Grau) e Média (3°Grau)</option>
                                                        <option value="2">Curso Técnico - Médio (2°Grau)</option>
                                                        <option value="3">Graduação</option>
                                                        <option value="4">Pós Graduação - Especialização</option>
                                                        <option value="5">Pós Graduação - MBA</option>
                                                        <option value="6">Pós Graduação - Mestrado</option>
                                                        <option value="7">Pós Graduação - Doutorado</option>
                                                        <option value="8">Cursos Complemetares</option>
                                                    </select> 
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <label for="situacaoAtual">Situação atual</label>
                                                    <select class="form-control" id="situacaoAtual">
                                                        <option value="0">Selecione</option>
                                                        <option value="1">Concluído</option>
                                                        <option value="2">Cursando</option>
                                                        <option value="3">Interrompido</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-2">
                                                    <label for="mesAnoConclusao">Mês/Ano de conclusão</label>
                                                    <input type="text" class="form-control" id="mesAnoConclusao" data-required="true">
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="third">
                                                <div class="form-group col-xs-12">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <label class="control-label" for="pretensaoSalarial">Pretensão salarial</label>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <input type="text" class="form-control" id="pretensaoSalarial" placeholder="R$" />
                                                        </div>
                                                        <div class="col-sm-1">
                                                            <p class="text-center">até</p>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <input type="text" class="form-control" placeholder="R$" />
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label for="vagaASerAplicado">Vaga a ser aplicado</label>
                                                    <select class="form-control" id="vagaASerAplicado" data-required="true">
                                                        <option value="">Selecione</option>
                                                        <option value="1">Desenvolvedor Java</option>
                                                        <option value="2">Desenvolvedor C#</option>
                                                        <option value="3">Analista de Sistemas</option>
                                                        <option value="4">Gerente de Projetos</option>
                                                        <option value="5">Banco de Talentos</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-4">
                                                    <label for="exampleInputEmail1">Como ficou sabendo desta vaga?</label>
                                                    <select class="form-control" data-required="true">
                                                        <option value="">Selecione</option>
                                                        <option value="1">Site Verity</option>
                                                        <option value="2">Facebook</option>
                                                        <option value="3">Linkedin</option>
                                                        <option value="4">ApInfo</option>
                                                        <option value="5">Catho</option>
                                                        <option value="6">Outros sites de oportunidades</option>
                                                        <option value="7">Indicação de colegas</option>
                                                        <option value="8">Outros</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-xs-12">
                                                    <label class="control-label">Currículo</label>
                                                    <div class="upload-file" style="width: 356px;">
                                                        <input type="file" id="upload-curriculo" class="upload-demo">
                                                        <label data-title="Selecione" for="upload-curriculo">
                                                            <span data-title="Nenhum arquivo selecionado..."></span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel-footer text-right">
                                        <button class="btn btn-success btn-sm disabled" id="prevStep" disabled="">Anterior</button>
                                        <button type="submit" class="btn btn-sm btn-success" id="nextStep">Próximo</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <!-- SOMENTE ALTERAR DAQUI PARA CIMA -->   
        
        <c:import url="shared/footer.jsp"></c:import>
        <c:import url="shared/js.jsp"></c:import>
    </body>
</html>