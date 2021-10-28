<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<fmt:bundle basename="message">
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	        <title><fmt:message key="bids.title"/></title>
	        <link rel="stylesheet" href="../css/global.css">
	        <link rel="stylesheet" href="../css/comprar.css">
	        <link rel="stylesheet" type="text/css" href="../slick/slick.css"/>
	        <link rel="stylesheet" type="text/css" href="../slick/slick-theme.css"/>
					
	    </head>
	    <body>
	        <%String contextPath = request.getContextPath().replace("/", ""); %>
	        <div class="topbar">
	            <ul id="links">
	                <li class="linkTopoEsquerda">
	                    <a href="${pageContext.request.contextPath}/clientes">
	                        <span id="titulo">LataVelhaInc.</span>
	                    </a>
	                </li>
	                <li class="nomeTopoDireita">
	                    <span><fmt:message key="user.welcome"/>: ${sessionScope.usuarioLogado.nome}</span>
	                    <ul class="dropdown">
	                        <li><a href="../logout"><fmt:message key="user.logout"/></a></li>
	                    </ul>
	                </li>
	                <li class="linkTopoDireita">
	                    <a href="../proposta/listarPropostasCliente"><fmt:message key="customer.bids"/></a>
	                </li>
	            </ul>
	        </div>
	        <section class="carro">
	                <div class="fotos">                
	                        <ul class="slider">
	                            <c:forEach var = "i" begin = "1" end = "${requestScope.num_files}">    
	                            <li>
	                                <img src="../imagens/${veiculo.id}/${i}.jpg" alt="Carro" />
	                            </li>
	                            </c:forEach>
	                        </ul>
	                </div>
	            <div class="info">
	                <c:set var="veiculo" value='${requestScope.veiculo}' />
	                <ul class="dadosCarro">
	                    <li class="nomeModelo">${veiculo.modelo} (${veiculo.ano}) - ${veiculo.quilometragem}km</li>
	                    <li>${veiculo.loja.nome}</li>
	                    <li><fmt:message key="vehicle.license"/>: ${veiculo.placa}</li>
	                    <li><fmt:message key="vehicle.chassis"/>: ${veiculo.chassi}</li>
	                    <li id="preco">R$${veiculo.valor}</li>
	                </ul>
	                    <c:forEach var="proposta" items="${requestScope.listaPropostas}">            
	                    	<c:if test ="${proposta.estado == 'ABERTO' && proposta.veiculo.id == veiculo.id}">
	                    		<c:set var = "block_proposta" scope = "page" value = "True"/>
	                    		<c:set var = "proposta_aberta" scope = "page" value = "${proposta}"/>
	                        </c:if>   
						</c:forEach>
						<c:choose>
	               			<c:when test="${pageScope.block_proposta == null}">
		                        <form id="form_proposta" action="../proposta/insereProposta?id_veiculo=${veiculo.id}&id_loja=${veiculo.loja.id}" method="post">
		                            <input id="pvalor" type="number" name="valor" placeholder="<fmt:message key="bids.value"/>" required>
	                                <input id="pparcelas" type="number" name="parcelamento" placeholder="<fmt:message key="bids.number.installments"/>" required>
		                            <input id="proposta" type="submit" name="Proposta" value="<fmt:message key="bids.make"/>">
	                        	</form>
	                        </c:when>
	                        <c:otherwise>
	                        	<div align="center">
									<h1 class="label"><fmt:message key="customer.open.bid"/></h1>
								</div>
	                       		<table class="propostas">
									<thead>
										<tr>
	                                        <th><fmt:message key="bids.date"/></th>
											<th><fmt:message key="bids.value"/></th>
	                        				<th><fmt:message key="customer.cancel.bid"/></th>
										</tr>
									</thead>
	                                <tbody>
	                                    <tr>
	                                        <td>${pageScope.proposta_aberta.data}</td>
	                                        <td>R$${pageScope.proposta_aberta.valor} ${pageScope.proposta_aberta.parcelamento}x</td>
	                                        <td id="botao_cancelar">
	                                            <a id="remover" href="../proposta/removerProposta?id=${pageScope.proposta_aberta.id}"><fmt:message key="bids.cancel"/></a>
	                                        </td>
	                                    </tr>
	                                </tbody>
								</table>
	                       </c:otherwise> 	
	                    </c:choose>
	            </div>
	            <div class="descricao">
	                <fmt:message key="vehicle.about"/>: ${veiculo.descricao}
	            </div>
	        </section>
	        <script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	        <script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	        <script type="text/javascript" src="../slick/slick.min.js"></script>
	        <script src="../js/carrossel.js"></script>
	    </body>
    </fmt:bundle>
</html>