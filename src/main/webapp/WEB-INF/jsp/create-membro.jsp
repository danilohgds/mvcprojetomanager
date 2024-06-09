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
    <title>Criar Membro</title>
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
                    <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/view-projetos">Projetos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/view-pessoas">Pessoas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">Membros</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="text-bg-primary p-3">
    <b>Gerenciador de Projetos - Associar Membro x Projeto</b>
</div>
<div style="width: 50vw; padding-left: 2vw">
    <form:form modelAttribute="command" method="put" action="/create-membro">
        <div class="mb-3">
            <label for="fcInputPessoaId" class="form-label">Nome Membro</label>
            <form:select class="form-select" id="fcInputPessoaId" aria-label="Nome Pessoa" path="idpessoa">
                <option selected>Pessoa</option>
                <c:forEach items="${pessoas}" var="pessoa">
                    <option value="${pessoa.id}">${pessoa.nome}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3">
            <label for="fcInputProjetoId" class="form-label">Nome Projeto</label>
            <form:select class="form-select" id="fcInputProjetoId" aria-label="Nome Projeto" path="idprojeto">
                <option selected>Projeto</option>
                <c:forEach items="${projetos}" var="projeto">
                    <option value="${projeto.id}">${projeto.nome}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="mb-3">
            <input type="submit" class="btn" value="Create"/>
        </div>
    </form:form>
</div>
</body>
</html>
