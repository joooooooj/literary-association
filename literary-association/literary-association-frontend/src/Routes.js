import React from "react";
import {Route, Switch} from "react-router-dom";
import Home from "./components/core/Home";
import Register from "./components/core/registration/Register";
import Pricing from "./components/membership/Pricing";
import ResetPassword from "./components/core/password/ResetPassword";
import RegisterSuccess from "./components/core/registration/RegisterSuccess";
import RegisterReader from "./components/core/registration/RegisterReader";
import RegisterBetaReader from "./components/core/registration/RegisterBetaReader";
import Books from "./components/books/Books";
import SubmittedWork from "./components/writer/registration/SubmittedWork";
import RegistrationRequest from "./components/board/registration/RegistrationRequests";
import RegistrationRequests from "./components/board/registration/RegistrationRequests";
import PublishBook from "./components/writer/publishing/PublishBook";
import PublishRequests from "./components/editor/publishing/PublishRequests";
import CorrectionsScripts from "./components/lector/CorrectionsScripts";
import CommentsScripts from "./components/reader/publishing/CommentsScripts";
import PlagiarismComplaint from "./components/writer/plagiarism/PlagiarismComplaint";
import MainEditorComplaints from "./components/editor/plagiarism/MainEditorComplaints";
import NotesComplaints from "./components/editor/plagiarism/NotesComplaints";
import ReviewNotes from "./components/board/plagiarism/ReviewNotes";

export default function Routes() {
    return (
        <Switch>
            <Route exact path="/">
                <Home/>
            </Route>
            <Route exact path="/home">
                <Home/>
            </Route>
            <Route exact path="/register">
                <Register/>
            </Route>
            <Route exact path="/pricing">
                <Pricing/>
            </Route>
            <Route exact path="/books">
                <Books/>
            </Route>
            <Route exact path="/reset-password">
                <ResetPassword/>
            </Route>
            <Route exact path="/register-success">
                <RegisterSuccess/>
            </Route>
            <Route exact path="/register-reader">
                <RegisterReader/>
            </Route>
            <Route exact path="/register-beta">
                <RegisterBetaReader/>
            </Route>
            <Route exact path="/submitted-work">
                <SubmittedWork/>
            </Route>
            <Route exact path="/registration-requests">
                <RegistrationRequests/>
            </Route>
            <Route exact path="/publish-book">
                <PublishBook/>
            </Route>
            <Route exact path="/publish-requests">
                <PublishRequests/>
            </Route>
            <Route exact path="/corrections-scripts">
                <CorrectionsScripts/>
            </Route>
            <Route exact path="/comments-scripts">
                <CommentsScripts/>
            </Route>
            <Route exact path="/plagiarism-complaint">
                <PlagiarismComplaint/>
            </Route>
            <Route exact path="/main-editor-complaints">
                <MainEditorComplaints/>
            </Route>
            <Route exact path="/notes-complaints">
                <NotesComplaints/>
            </Route>
            <Route exact path="/review-notes">
                <ReviewNotes/>
            </Route>
            <Route>
                <Home/>
            </Route>
        </Switch>
    );
}