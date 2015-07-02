/**
 * Created by Hyago on 01/07/2015.
 */
class Util {

    static def checkdir(def path){
        def f = new File(path)
        if(!f.exists()) {
            boolean created = f.mkdirs()
            println("Directory was ${created ? 'created' : 'not created'} at: ${path}")
        }
    }
}
