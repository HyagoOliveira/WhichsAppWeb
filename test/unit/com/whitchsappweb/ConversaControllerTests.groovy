package com.whitchsappweb


import org.junit.*
import grails.test.mixin.*

@TestFor(ConversaController)
@Mock(Conversa)
class ConversaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/conversa/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.conversaInstanceList.size() == 0
        assert model.conversaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.conversaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.conversaInstance != null
        assert view == '/conversa/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/conversa/show/1'
        assert controller.flash.message != null
        assert Conversa.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/conversa/list'

        populateValidParams(params)
        def conversa = new Conversa(params)

        assert conversa.save() != null

        params.id = conversa.id

        def model = controller.show()

        assert model.conversaInstance == conversa
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/conversa/list'

        populateValidParams(params)
        def conversa = new Conversa(params)

        assert conversa.save() != null

        params.id = conversa.id

        def model = controller.edit()

        assert model.conversaInstance == conversa
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/conversa/list'

        response.reset()

        populateValidParams(params)
        def conversa = new Conversa(params)

        assert conversa.save() != null

        // test invalid parameters in update
        params.id = conversa.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/conversa/edit"
        assert model.conversaInstance != null

        conversa.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/conversa/show/$conversa.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        conversa.clearErrors()

        populateValidParams(params)
        params.id = conversa.id
        params.version = -1
        controller.update()

        assert view == "/conversa/edit"
        assert model.conversaInstance != null
        assert model.conversaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/conversa/list'

        response.reset()

        populateValidParams(params)
        def conversa = new Conversa(params)

        assert conversa.save() != null
        assert Conversa.count() == 1

        params.id = conversa.id

        controller.delete()

        assert Conversa.count() == 0
        assert Conversa.get(conversa.id) == null
        assert response.redirectedUrl == '/conversa/list'
    }
}
