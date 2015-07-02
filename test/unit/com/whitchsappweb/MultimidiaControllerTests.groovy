package com.whitchsappweb


import org.junit.*
import grails.test.mixin.*

@TestFor(MultimidiaController)
@Mock(Multimidia)
class MultimidiaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/multimidia/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.multimidiaInstanceList.size() == 0
        assert model.multimidiaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.multimidiaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.multimidiaInstance != null
        assert view == '/multimidia/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/multimidia/show/1'
        assert controller.flash.message != null
        assert Multimidia.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/multimidia/list'

        populateValidParams(params)
        def multimidia = new Multimidia(params)

        assert multimidia.save() != null

        params.id = multimidia.id

        def model = controller.show()

        assert model.multimidiaInstance == multimidia
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/multimidia/list'

        populateValidParams(params)
        def multimidia = new Multimidia(params)

        assert multimidia.save() != null

        params.id = multimidia.id

        def model = controller.edit()

        assert model.multimidiaInstance == multimidia
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/multimidia/list'

        response.reset()

        populateValidParams(params)
        def multimidia = new Multimidia(params)

        assert multimidia.save() != null

        // test invalid parameters in update
        params.id = multimidia.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/multimidia/edit"
        assert model.multimidiaInstance != null

        multimidia.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/multimidia/show/$multimidia.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        multimidia.clearErrors()

        populateValidParams(params)
        params.id = multimidia.id
        params.version = -1
        controller.update()

        assert view == "/multimidia/edit"
        assert model.multimidiaInstance != null
        assert model.multimidiaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/multimidia/list'

        response.reset()

        populateValidParams(params)
        def multimidia = new Multimidia(params)

        assert multimidia.save() != null
        assert Multimidia.count() == 1

        params.id = multimidia.id

        controller.delete()

        assert Multimidia.count() == 0
        assert Multimidia.get(multimidia.id) == null
        assert response.redirectedUrl == '/multimidia/list'
    }
}
