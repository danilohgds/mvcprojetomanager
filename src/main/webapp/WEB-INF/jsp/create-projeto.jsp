<%--
  Created by IntelliJ IDEA.
  User: Dan
  Date: 6/5/2024
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Criar Projeto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Gerenciador de Projetos</a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Projetos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/view-pessoas">Pessoas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/view-membros">Membros</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="text-bg-primary p-3">
  <b>Gerenciador de Projetos - Adicionar Projeto</b>
</div>
  <div style="width: 50vw; padding-left: 2vw">
    <form:form modelAttribute="command" method="put" action="/create-projeto">
    <div class="mb-3">
      <label for="fcInputNome" class="form-label">Nome</label>
      <form:input type="text" class="form-control" id="fcInputNome" placeholder="nome do projeto" path="nome"/>
    </div>
    <div class="mb-3">
      <label for="fcInpubataInicio" class="form-label">Data de início</label>
      <form:input type="text" class="form-control" id="fcInpubataInicio"
                  placeholder="data de início" path="dataInicio"/>
    </div>
    <div class="mb-3">
      <label for="fcInputGerenteResp" class="form-label">Gerente Responsável</label>
      <form:select class="form-select" id="fcInputGerenteResp" aria-label="gerente responsável" path="idgerente">
        <option selected>Gerente Responsável</option>
        <c:forEach items="${pessoas}" var="pessoa">
          <%--        <tr>--%>
          <option value="${pessoa.id}">${pessoa.nome}</option>
          <%--        </tr>--%>
        </c:forEach>
      </form:select>
    </div>
    <div class="mb-3">
      <label for="fcInputPrevisaoTermino" class="form-label">Previsão de término</label>
      <form:input type="text" class="form-control" id="fcInputPrevisaoTermino"
                  placeholder="previsão de término"  path="dataPrevisaoTermino" />
    </div>
    <div class="mb-3">
      <label for="fcInpubataTermino" class="form-label">Data real de término</label>
      <form:input type="text" class="form-control" id="fcInpubataTermino"
                  placeholder="data real de término"  path="dataRealTermino" />
    </div>
    <div class="mb-3">
      <label for="fcInputOrcamentoTotal" class="form-label">Orçamento Total</label>
      <form:input type="text" class="form-control" id="fcInputOrcamentoTotal"
                  placeholder="Orçamento Total" path="orcamentoTotal"/>
    </div>
    <div class="mb-3">
      <label for="fcInputRiscoProjeto" class="form-label">Risco Projeto</label>
      <form:select class="form-select" id="fcInputRiscoProjeto" aria-label="Default select example" path="risco">
        <option selected>Risco Projeto</option>
        <option value="Baixo">Baixo</option>
        <option value="Médio">Médio</option>
        <option value="Alto">Alto</option>
      </form:select>
    </div>
    <div class="mb-3">
      <label for="fcInputStatusProjeto" class="form-label">Status Projeto</label>
      <form:select class="form-select" id="fcInputStatusProjeto" aria-label="Default select example" path="status">
        <option selected>Status Projeto</option>
        <option value="em análise">em análise</option>
        <option value="análise realizada">análise realizada</option>
        <option value="análise aprovada">análise aprovada</option>
        <option value="iniciado">iniciado</option>
        <option value="planejado">planejado</option>
        <option value="em andamento">em andamento</option>
        <option value="encerrado">encerrado</option>
        <option value="cancelado">cancelado</option>
      </form:select>
    </div>
    <div class="mb-3">
      <input type="submit" class="btn" value="Create"/>
    </div>
    </form:form>
  </div>
</body>
</html>
