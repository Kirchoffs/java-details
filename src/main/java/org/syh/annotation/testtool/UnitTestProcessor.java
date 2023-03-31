package org.syh.annotation.testtool;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes({"UnitTest"})
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class UnitTestProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment environment) {
        for (Element cls: environment.getElementsAnnotatedWith(UnitTest.class)) {
            UnitTest ut = cls.getAnnotation(UnitTest.class);

            String newFileStr = "public class " + ut.prefix() + cls.getSimpleName() + "{\n\n";

            // Constructor
            newFileStr += "public " + ut.prefix() + cls.getSimpleName() + "() {\n";
            newFileStr += "}\n\n";

            // Main method
            newFileStr += "public static void main(String[] args) {\n";

            // New instance
            newFileStr += cls.getSimpleName() + " clz = new " + cls.getSimpleName() + "();\n";

            // Test methods
            for (Element testMethod: cls.getEnclosedElements()){
                if (!testMethod.getSimpleName().toString().equals("<init>") &&
                    testMethod.asType() instanceof ExecutableType) {
                    newFileStr += "clz." + testMethod.getSimpleName() + "();\n";
                }
            }

            newFileStr += "}\n"; // end of main()
            newFileStr += "}\n"; // end of class

            try {
                JavaFileObject jfo = processingEnv.getFiler().createSourceFile(ut.prefix() + cls.getSimpleName(), cls);
                Writer writer = jfo.openWriter();
                writer.append(newFileStr);
                writer.flush();
                writer.close();
            } catch (IOException ex) {}
        }

        return true;
    }
}
