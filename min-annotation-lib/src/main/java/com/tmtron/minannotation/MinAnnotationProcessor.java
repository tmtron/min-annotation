package com.tmtron.minannotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("com.tmtron.minannotation.MinAnnotation")
public class MinAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MinAnnotation.class);
        final Messager messager = processingEnv.getMessager();
        for(Element element : elements){
            messager.printMessage(Diagnostic.Kind.NOTE, "Annotated Element: "+element.toString());
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
