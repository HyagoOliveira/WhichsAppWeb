<%@ page import="com.whitchsappweb.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'apelido', 'error')} ">
	<label for="apelido">
		<g:message code="usuario.apelido.label" default="Apelido" />
		
	</label>
	<g:textField name="apelido" maxlength="15" value="${usuarioInstance?.apelido}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'profilePicture', 'error')} ">
	<label for="file">
		<g:message code="usuario.profilePicture.label" default="Profile Picture" />
		
	</label>
	<input type="file" id="file" name="file" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'contatos', 'error')} ">
	<label for="contatos">
		<g:message code="usuario.contatos.label" default="Contatos" />
		
	</label>
	<g:select name="contatos" from="${com.whitchsappweb.Usuario.list()}" multiple="multiple" optionKey="id" size="5" value="${usuarioInstance?.contatos*.id}" class="many-to-many"/>
</div>

