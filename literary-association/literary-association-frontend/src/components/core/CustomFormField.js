import {Form} from "react-bootstrap";
import Select from "react-select";
import React, {useEffect, useState} from "react";

export default function CustomFormField({formField, register, errors}) {

    const [selectValue, setSelectValue] = useState("");

    const setOptions = (options) => {
        // Rename Objects in SelectDTO instead of Genres (generic) maybe?
        let removeGenre = options.replaceAll("Genre", '');
        removeGenre = removeGenre.replaceAll("CityAndCountry", '');
        removeGenre = removeGenre.replaceAll("value", '"label"');
        removeGenre = removeGenre.replaceAll("id", '"value"');
        removeGenre = removeGenre.replaceAll("=", ":");
        removeGenre = removeGenre.replaceAll("'", '"');
        return JSON.parse(removeGenre);
    }

    const setRef = (constraints) => {
        let refs = "{";
        constraints.forEach((constraint, index) => {
            refs += '"' + constraint.name + '" : ' + constraint.configuration;
            if (index !== (constraints.length - 1)) {
                refs += ","
            }
        })
        refs += "}";
        return JSON.parse(refs);
    }

    const checkErrors = (id) => {
        for (let prop in errors) {
            if (prop === id) {
                return true;
            }
        }

        return false;
    }

    const addClassToSelectChild = () => {
        document.getElementById("select-id").firstElementChild.classList.add("invalid-custom");
    }

    return (
        <Form.Group className="text-left">
            <Form.Label>{formField.label}</Form.Label>
            {formField.type.name === "string" &&
            <>
                {!formField.properties.subType &&
                <>
                    <Form.Control isInvalid={checkErrors(formField.id)} name={formField.id} type="text"
                                  placeholder={formField.properties.placeholder}
                                  ref={register(setRef(formField.validationConstraints))}/>
                </>
                }
                {formField.properties.subType &&
                <>
                    {formField.properties.subType === "select" &&
                    <>
                        <Select id="select-id"
                                className={(checkErrors(formField.id) ? addClassToSelectChild() : "") + " text-dark"}
                                options={setOptions(formField.properties.options)}
                                placeholder={formField.properties.placeholder}
                                onChange={(selected) => {
                                    let input = document.getElementById('hidden-input' + formField.id);

                                    let nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, "value").set;
                                    nativeInputValueSetter.call(input, selected.value);

                                    let ev2 = new Event('input', {bubbles: true});
                                    input.dispatchEvent(ev2);
                                }
                                }
                        />
                        <Form.Control id={"hidden-input" + formField.id} isInvalid={checkErrors(formField.id)}
                                      name={formField.id}
                                      type="text" className="hidden"
                                      ref={register(setRef(formField.validationConstraints))} readOnly/>
                    </>
                    }
                    {formField.properties.subType === "textarea" &&
                    <>
                        <Form.Control isInvalid={checkErrors(formField.id)} name={formField.id} as="textarea" rows={5}
                                      placeholder={formField.properties.placeholder}
                                      ref={register(setRef(formField.validationConstraints))}/>
                    </>
                    }
                </>
                }
                {
                    checkErrors(formField.id) &&
                    <Form.Control.Feedback type="invalid">
                        <span className="text-danger">{formField.id.toUpperCase()} IS INVALID!</span>
                    </Form.Control.Feedback>
                }
            </>
            }
        </Form.Group>
    );
}
